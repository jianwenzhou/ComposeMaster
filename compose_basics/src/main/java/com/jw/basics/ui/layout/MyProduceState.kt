package com.jw.basics.ui.layout

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.imageLoader
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/26 22:48
 * @Des ProduceState作用：
 * 1.可以将非Compose状态转换为Compose状态，例如LiveData，Flow等等。
 * 2.ProduceState创建了一个协程，但是也可以观察非挂起的数据源
 * 3.当ProduceState进入Composition时候，获取数据的任务被启动，
 *   当其离开Composition时候，该任务被取消。
 */
@Composable
fun MyProduceState() {

    val data = remember {
        listOf(
            "https://pixabay.com/get/ga8e4f8ead34ccc4635f7edf959ea3313a1996067e5482103c82d30ca1755dea11c5ca965dd74fb5e553cb8f6d31e0d55_1280.jpg",
            "https://pixabay.com/get/g9b550323e66315eeed7977b0fe59cf2476334c4f549c2bc2cd2c5b955b2288ae5742ef82e2ae5410774847e895ae1fed901f390c1236db2f64c16e1df1e2f7d4_1280.jpg",
            "https://pixabay.com/get/ga8a2d9b6cd90e7a02a79b26f5313f750402b02f5e6d36ceec75e3ee5b105f6edcf1b68332304e8ff6401c2c07ed71910a5bcd4ef06cc8e56861fb9ac2f95764b_1280.jpg",
            "https://错误.com/get/gb125972976f4d08f37d734ddc315ba96ca7f9f444fa00a5e076f4d832cf94eb83d85496dccc03d3004511bd4e8fef92d_1280.jpg",
        )
    }
    //1.Button点击，会改变index的值
    var index by remember { mutableStateOf(0) }
    //2.创造一个图片加载对象
    val imageRepository = ImageRepository(LocalContext.current)
    //3.index的值改变，会执行LoadNetImage函数
    val imageState = loadNetImage(data[index], imageRepository)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(onClick = {
            index++
            if (index == data.size) {
                index = 0
            }
        }) {
            Text(text = "切换图片")
        }

        //7.当imageState发生改变，下面可组合函数会发生重组，通过value来展示图片内容。
        when (imageState.value) {
            is Result.Success -> {
                val drawable = (imageState.value as Result.Success).image.drawable
                val bitmap = (drawable as BitmapDrawable).bitmap.asImageBitmap()

                Image(
                    bitmap = bitmap,
                    contentDescription = "",
                    modifier = Modifier.size(200.dp)
                )
            }
            is Result.Error -> {
                Image(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "",
                    modifier = Modifier.size(200.dp)
                )
            }
            is Result.Loading -> {
                CircularProgressIndicator()
            }
        }
    }

}

@Composable
fun loadNetImage(url: String, imageRepository: ImageRepository): State<Result<ImageData>> {
    //4.创建produceState，默认值设置Loading。
    return produceState(initialValue = Result.Loading as Result<ImageData>, url, imageRepository) {
        //5.通过imageRepository.load，将url转化为drawable。
        val imageData = imageRepository.load(url)
        //6.通过设值给value，来更新State。
        value = if (imageData == null) {
            Result.Error
        } else {
            Result.Success(imageData)
        }
    }

}


/**
 * 图片加载框架
 */
class ImageRepository(val context: Context) {

    suspend fun load(url: String): ImageData? {
        return withContext(Dispatchers.IO) {
            val imageLoader = context.imageLoader
            val request = ImageRequest.Builder(context)
                .data(url)
                .build()
            val drawable = imageLoader.execute(request).drawable
            if (drawable == null) {
                null
            } else {
                ImageData(drawable)
            }
        }
    }

}

data class ImageData(val drawable: Drawable)

/**
 * sealed关键字：密封类，超强的枚举
 */
sealed class Result<T> {
    object Loading : Result<ImageData>()
    object Error : Result<ImageData>()
    data class Success(var image: ImageData) : Result<ImageData>()
}

