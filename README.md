# ComposeMaster
api库:网络请求相关
compose_basics库:Compose基础学习
compose_demo库:依据Compose的学习,写一个相对完整的demo项目

# Jetpack Compose

## 基础知识

### Compose基本概念

Jetpack Compose 是一个用于构建原生 Android UI 的现代工具包。Jetpack Compose 使用更少的代码、强大的工具和直观的 Kotlin API 简化并加速了 Android 上的 UI 开发。

#### 声明性编程范式

在许多面向对象的命令式界面工具包中，您可以通过实例化微件树来初始化界面。您通常通过膨胀 XML 布局文件来实现此目的。每个微件都维护自己的内部状态，并且提供 getter 和 setter 方法，允许应用逻辑与微件进行交互。

在 Compose 的声明性方法中，**微件相对无状态**，并且不提供 setter 或 getter 函数。实际上，微件不会以对象形式提供。您可以通过调用带有不同参数的同一可组合函数来更新界面。这使得向架构模式（如 ViewModel）提供状态变得很容易，如应用架构指南中所述。然后，**可组合项负责在每次可观察数据更新时将当前应用状态转换为界面**。

#### 可组合函数

Jetpack Compose 是围绕可组合函数构建的。
这些函数让您可以通过描述应用程序的外观和提供数据依赖项来以编程方式定义应用程序的 UI，而不是专注于 UI 的构建过程（初始化元素、将其附加到父级等）。要创建可组合函数，只需
@Composable在函数名称中添加注释即可。
```
@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}
```

#### 预览函数

实时预览可组合函数
```
@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard("Android")
}
```

#### 重组

1.Compose重组，往往和State相关。
当State的值发生变化时候，使用该值的可组合函数就会发生重组。

2.Compose 会尽力只重组需要更新的部分,称为智能重组.

### Compose的优势

#### 更少的代码

使用更少的代码实现更多的功能.代码简洁易维护.

#### 直观

只需要描述界面,Compose会负责处理剩余的工作.应用状态变化时,界面会自动更新.

#### 加快应用开发

兼容现有代码,方便随时随地采用,借助实时预览,实现快速迭代.

#### 功能强大

凭借对Android平台Api的直接访问,和对于material Design,深色主题,动画的内置支持,创建精美的应用.

### Compose和View的关系

1.Compose在渲染时并不会转化成View，而是只有一个入口View，即AndroidComposeView,纯Compose项目下，AndroidComposeView没有子View.
2.我们声明的Compose布局在渲染时会转化成NodeTree,AndroidComposeView中会触发NodeTree的布局与绘制,AndroidComposeView#dispatchDraw是绘制的入口.
3.在Android平台上，Compose的布局与绘制已基本脱离View体系，但仍然依赖于Canvas.
4.由于良好的分层体系，Compose可通过 compose.runtime和compose.compiler实现跨平台.

### Compose的原理

Compose的原理,某种程度上来说就是@Composable注解的原理.

1.使用@Composable注解,这是因为我们需要一个贯穿所有的上下文调用对象。

2.传递的上下文称为Composer,Composer 的实现包含了一个与 Gap Buffer (间隙缓冲区) 密切相关的数据结构，这一数据结构通常应用于文本编辑器。
间隙缓冲区是一个含有当前索引或游标的集合，它在内存中使用扁平数组 (flat array) 实现。这一扁平数组比它代表的数据集合要大，而那些没有使用的空间就被称为间隙。

3.通过2中的数据结构,更新UI时,编译器将缝隙移动至当前游标位置并使其在以前 UI 的位置进行扩展，从而有效地消除了旧的UI。


参考第三方文档:
https://zhuanlan.zhihu.com/p/270682182

Compose的状态:
1.组合：要显示什么样的界面。Compose 运行可组合函数并创建界面说明。

2.布局：要放置界面的位置。该阶段包含两个步骤：测量和放置。对于布局树中的每个节点，布局元素都会根据 2D 坐标来测量并放置自己及其所有子元素。

3.绘制：渲染的方式。界面元素会绘制到画布（通常是设备屏幕）中。

### Compose项目配置

Android 在现有项目中引入Compose:

1.需要按照Android Studio Bumblebee版本.

2.gradle插件配置,配置与 Android Studio 版本对应的 Android Gradle 插件：
```
buildscript {
    ...
    dependencies {
        classpath "com.android.tools.build:gradle:7.0.0"
        ...
    }
}
```

3.配置 Kotlin,确保您在项目中使用的是 Kotlin 1.5.31：
```
plugins {
    id 'org.jetbrains.kotlin:android' version '1.5.31'
}
```

4.配置 Gradle:您需要将应用的最低 API 级别设置为 21 或更高级别，并在应用的 build.gradle 文件中启用 Jetpack Compose，如下所示。另外还要设置 Kotlin 编译器插件的版本:
```
android {
    defaultConfig {
        ...
        minSdkVersion 21
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose true
    }
    ...

    // Set both the Java and Kotlin compilers to target Java 8.
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion '1.0.5'
    }
}
```

5.添加 Jetpack Compose 工具包依赖项
```
dependencies {
    // Integration with activities
    implementation 'androidx.activity:activity-compose:1.3.1'
    // Compose Material Design
    implementation 'androidx.compose.material:material:1.0.5'
    // Animations
    implementation 'androidx.compose.animation:animation:1.0.5'
    // Tooling support (Previews, etc.)
    implementation 'androidx.compose.ui:ui-tooling:1.0.5'
    // Integration with ViewModels
    implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07'
    // UI Tests
    androidTestImplementation 'androidx.compose.ui:ui-test-junit4:1.0.5'
}
```




## 布局

### Column

#### 垂直布局，类似垂直的LinearLayout

### Row

#### 水平布局，类似水平的LinearLayout

### Box

#### 层叠布局，类似帧布局效果

### Scaffold

#### 脚手架

包括顶部应用程序栏和底部栏、抽屉和浮动操作按钮等

### ConstraintLayout

#### 约束布局

需要添加依赖
implementation 'androidx.constraintlayout:constraintlayout-compose:1.0.0'

### ScrollView

#### 滚动布局

类似原生View的scrollView
Modifier.verticalScroll 垂直滑动
Modifier.horizontalScroll 横向滑动
底层通过重组实现滑动

## 常用组件

### Text

#### 类似TextView

示例代码：
```
Text(
text=stringResource(id=R.string.test_string)
)
```

### Image

#### 类似ImageView

示例代码：
```
Image(
painter = painterResource(id = R.mipmap.main),
contentDescription = "Image",
)
```

### Button

#### 类似Button

示例代码：
```
Button(onClick = {"点击事件"}) {
	Text(text = "Button文字")
}
```

### TextField

#### 类似Edittext

示例代码：
```
TextField(
   value = "展示的文本",           
   onValueChange = { "输入的文本" 	}
)
```

### Card

#### 类似CardView

示例代码：
 ```
Card(
modifier=modifier.fillMaxWidth(),
shape=RoundedCornerShape(15.dp),//shape 圆角
elevation = 5.dp     //阴影
) {
    #卡片的内容
}
```

### Pager

#### 类似ViewPager

需要添加依赖
implementation "com.google.accompanist:accompanist-pager:0.21.1-beta"

示例代码：
```
HorizontalPager(
   count = 4,
   modifier = Modifier.weight(1f)
   ) { page ->
      when (page) {
         0 -> {
              NewsPage()
         }
         1 -> {
              MoviePage()
         }
         2 -> {
              PicturePage()
         }
         3 -> {
              MusicPage()
          }
      }
 }
```

### LazyRow

#### 类似水平的RecyclerView

示例代码：
```
LazyRow {
	items(**这里传入数据集合**) {
     **这里处理Item的组件显示**
   }
}
```
**超级超级nice，再也不用写Adapter，写Item的layout！！！**

### LazyColumn

#### 类似垂直的RecyclerView

示例代码：
```
LazyColumn {
	items(**这里传入数据集合**) {
     **这里处理Item的组件显示**
   }
}
```

### LazyVerticalGrid

#### 类似垂直的GridView

示例代码：
```
 LazyVerticalGrid(
    cells = GridCells.Fixed(3)
    content = {
       items(**传入数据集合**) { 
       **展示Item的组件**
	}
)
```

### 自定义控件

#### 分支主题

下述代码实现了一个自定义的Column.主要围绕Layout可组合函数,测量子组合,从而设置每个子组合的Y值,实现线性布局.

示例代码:
```

@Composable
fun MyColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
         modifier = modifier,
         content = content
    ) { measurables, constraints ->
 // 测量每个项目并将其转换为 Placeable
 val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }
 // Column 的高度是所有项目所测得高度之和
 val height = placeables.sumOf { it.height }
 // Column 的宽度则为内部所含最宽项目的宽度
 val width = placeables.maxOf { it.width }
 // 报告所需的尺寸
 layout (width, height) {
 // 通过跟踪 y 坐标放置每个项目
  var y = 0
  placeables.forEach { placeable ->
placeable.placeRelative(x = 0, y = y)
  // 按照所放置项目的高度增加 y 坐标值
  y += placeable.height
      }
  }
}




}
```

## 状态

### 简介

应用中的状态是指可以随时间变化的任何值。

例如，状态可能是存储在 Room 数据库中的值、类的变量，甚至是加速度计的当前读数。

### 单向数据流

**单向数据流是一种事件向上流动而状态向下流动的设计。**

例如，在 ViewModel 事件中，系统会使用方法调用从界面向上传递事件，而使用 LiveData 向下流动状态。

这不仅仅是一个用于描述 ViewModel 的术语，任何事件向上流动而状态向下流动的设计都是单向的。

### 状态提升

**状态提升是一种将状态上移以使组件变为无状态的模式。**

当应用于可组合项时，这通常意味着向可组合项引入两个参数。

value: T - 要显示的当前值
onValueChange: (T) -> Unit - 请求更改值的事件，其中 T 是建议的新值

示例代码：
TextField是Compose提供的输入可组合函数。
value参数是TextField要展示的文本，onValueChange参数是当前输入最新的内容。
**TextField内部并不会对输入的Value进行任何修改，而是会通过onValueChange回调出来。体现了向上流动事件。而value参数的设置，体现了向下传递状态。**

```
TextField(
    value = text1,  //展示内容
    onValueChange = { text1 = it }, //输入监听
)
```

### Compose中的内存

remember 提供了可组合函数内存。

系统会将由 remember 计算的值存储在组合树中，而且只有当 remember 的键**发生变化**时才会重新计算该值。

您可以将 remember 看作是为函数提供单个对象的存储空间，过程与 private val 属性在对象中执行的操作相同。

示例代码：
```
val iconAlpha: Float = remember(key) {0.5}
```

### ViewModel 中使用状态

示例代码：通过mutableStateListOf，可以创建一个可观察的状态。
```
var todoItems = mutableStateListOf<TodoItem>()
```

### LiveData和State

需要添加依赖
```
implementation "androidx.compose.runtime:runtime-livedata:$compose_version"
```
通过observeAsState可以将LiveData转为Stat
```
val observeAsState = model.imageLiveData.observeAsState(listOf())
```

## 弹窗

### Dialog

#### DIalog可组合函数

下列代码是AlertDialog的可组合函数，由参数名基本就知道入参的含义了。
```
fun AlertDialog(
    onDismissRequest: () -> Unit,
    buttons: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    title: (@Composable () -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    properties: DialogProperties = DialogProperties()
)
```
其实AlertDialog内部用的是Dialog的可组合函数，非常灵活，content作为回调函数，内部可以自定义弹窗的内容。
```
fun Dialog(
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    content: @Composable () -> Unit
)
```

### Popup

#### PopupWindow可组合函数

下面代码是Popup的可组合函数，
alignment用于设定popup的位置，
offset用于x和y的偏移量。
```
fun Popup(
    alignment: Alignment = Alignment.TopStart,
    offset: IntOffset = IntOffset(0, 0),
    onDismissRequest: (() -> Unit)? = null,
    properties: PopupProperties = PopupProperties(),
    content: @Composable () -> Unit
)
```

## 动画

### AnimatedVisibility

#### 为可见性添加动画效果

AnimatedVisibility，用于包裹展示隐藏中切换的内容，AnimatedVisibility的enter和exit参数有默认值，默认值是透明度动画，也可以自定义设置。
```
AnimatedVisibility(visible = isVis) {
	**内容**
}
```

### animateColorAsState

#### 颜色切换动画

animateColorAsState是一个状态,颜色值线性变化，State变化都会导致可组合函数的重组。

```
val backgroundColor by animateColorAsState(if (isChange) Color.Red else Color.Yellow)
```

### animateContentSize

#### 内容大小变化动画

animateContentSize是修饰符modifier的一个函数，调用后，当Text在单行和多行切换时候，会附加过渡动画。
```
Text(
   text = "超长文本",
   maxLines = if (isOpen) Int.MAX_VALUE else 1,
   modifier = Modifier
    .fillMaxWidth()
    .padding(50.dp)
    .animateContentSize()
  )
```

### rememberInfiniteTransition

#### 重复动画

rememberInfiniteTransition类似ValueAnimation（属性动画），针对透明度，位置，缩放值，设置repeatMode和时长。
```
val infiniteTransition = rememberInfiniteTransition()
val alpha by infiniteTransition.animateFloat(
    initialValue = 0f,
    targetValue =1f,
  animationSpec=infiniteRepeatable(
   animation = keyframes {
      durationMillis = 1000
                0.7f at 500
            },
      repeatMode=RepeatMode.Reverse
        )
    )
```

## 主题

### 简介

Jetpack Compose 提供了 Material Design 的实现，后者是一个用于创建数字化界面的综合设计系统。Material Design 组件（按钮、卡片、开关等）在 Material 主题设置的基础上构建而成，Material 主题设置是一种系统化的方法，用于自定义 Material Design 以更好地反映您产品的品牌。一个 Material 主题由颜色、排版和形状属性组成。如果您自定义这些属性，相应设置会自动反映在您用来构建应用的组件中。

### MaterialTheme

Compose中主题的设置,是通过MaterialTheme可组合函数实现的.
MaterialTheme的四个参数如下示例:

```
@Composable
fun MaterialTheme(
    colors: Colors = MaterialTheme.colors,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) 
```

### 颜色

Compose中Colors的类如下:
```
@Stable
class Colors(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    background: Color,
    surface: Color,
    error: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
    isLight: Boolean
)
```
要点:
1.**Ui统一性**,由于Material强调UI统一性,各个可组合控件(例如Button,Text等等背景色都是取自此类,很大程度维护了Ui颜色统一性.)
2.**适配黑夜皮肤**,只需要创建两个Color类,一个白天,一个黑夜,根据系统提供的**isSystemInDarkTheme()**,使用不同的Color即可.
3.**自定义颜色**,突破MaterialTheme中Colors的限制.
通过staticCompositionLocalOf和CompositionLocalProvider搭配使用,可以自定义颜色属性.

### 排版

排版,其实就是字体样式,可以设置大小,字体,权重(加粗等)
```
fun typographyFromDefaults(
    h1: TextStyle?,
    h2: TextStyle?,
    h3: TextStyle?,
    h4: TextStyle?,
    h5: TextStyle?,
    h6: TextStyle?,
    subtitle1: TextStyle?,
    subtitle2: TextStyle?,
    body1: TextStyle?,
    body2: TextStyle?,
    button: TextStyle?,
    caption: TextStyle?,
    overline: TextStyle?
)
```

### 形状

形状,类似View体系中的Shape,Compose中可以把Shape传入主题中,Button,Card等控件默认使用了主题中的Shape.
```
class Shapes(
    val small: CornerBasedShape = RoundedCornerShape(4.dp),
    
    val medium: CornerBasedShape = RoundedCornerShape(4.dp),
   
    val large: CornerBasedShape = RoundedCornerShape(0.dp)
)
```

## CompositionLocal

### 简介

CompositionLocal:隐式传参，MaterialTheme里面的color，shape等等都是通过staticCompositionLocalOf生成的。
* 要点1.infix函数 LocalContentAlpha provides ContentAlpha.medium 等于 LocalContentAlpha.provides(ContentAlpha.medium)
* 要点2.通过CompositionLocalProvider修改LocalContentAlpha,只针对CompositionLocalProvider的域下剩下。
* 要点3.Compose中已经封装了很多CompositionLocal,例如context,键盘管理,ClipboardManager,lifecycle等等常用的小组件.

### compositionLocalOf

使用compositionLocalOf创造
CompositionLocal

存储的值会经常改变.
例如动画、主题等等

### staticCompositionLocalOf

使用staticCompositionLocalOf创造
CompositionLocal

由static可知,创造的内容通常是静态的,可以减少内存开销.
例如Andorid上下文对象，字体加载器，或者共享元素等等.

### 常用功能

#### 上下文

Compose中弹出Toast
```
val context = LocalContext.current
 Toast.makeText(context, "LocalContext", Toast.LENGTH_SHORT).show()
```

#### 输入法

在可组合函数中,通过下列代码可以获取键盘管理器,控制键盘的展示隐藏.
```
LocalSoftwareKeyboardController.current
```

#### lifecycle

Compose中使用lifecycle,通过下述代码获取,Compose中使用mapView,VideoView的时候,需要根据Activity的生命周期进行相关的操作.
```
val lifecycle = LocalLifecycleOwner.current.lifecycle
```

#### MaterialTheme

通过MaterialTheme来获取color,shape,typography值,本质上是通过staticCompositionLocalOf

示例如下:
```
internal val LocalColors = staticCompositionLocalOf { lightColors() }
```

## 手势

### 点击

通过Modifier.clickable添加
示例代码;
```
modifier = Modifier
          .clickable { count++ })
```

### 双击，常按，抬起等事件


```
 modifier = Modifier
.pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        log += "双击]   "
                    },
                    onLongPress = {
                        log += "长按]   "
                    },
                    onPress = {
                        log += "   [按下->"
                    },
                    onTap = {
                        log += "单击]   "
                    })
            })
```

### 滚动

通过modifier设置verticalScroll,即可实现垂直滚动,同理也可以给Row设置实现水平滚动.
```
Column(
  modifier = Modifier .verticalScroll(scrollState)
)
```

### 拖动

通过Modifier修饰符,监听detectDragGestures状态,即可得到当前可组合控件拖动的x,y值

```
Modifier
.pointerInput(Unit) {
 detectDragGestures { change, dragAmount ->
 offsetX += dragAmount.x
 offsetY += dragAmount.y
 }
}
```

### 滑动

通过Modifier的swipeable修饰符,可以得到当前可组合控件的滑动值.
示例:
```
modifier = Modifier
.swipeable(
   state = state,
   orientation = Orientation.Horizontal,
   anchors = anchors,
   thresholds = { from: Int, to: Int -> FractionalThreshold(0.3f) }//阈值,超过30%就滑过去,低于30%就滑回来.
)
```

### 多点触控

通过Modifie的transformable修饰符,传入rememberTransformableState,

```
val state =
rememberTransformableState(onTransformation = { zoomChange, panChange, rotationChange ->
    zoom *= zoomChange
    pan += panChange
    rotation += rotationChange
})

Box(modifier = Modifier
   .transformable(state = state)
)  
```

## 项目迁移

### Compose中使用原生控件

Compose中使用原生控件，例如mapView，VideoView，webView，还有一些其他的复杂控件，就需要用AndroidView来包裹，从而在Compose中使用原生View控件。
***重点就是各个生命周期管理，以及状态提升。**
示例代码:
 ```
 AndroidView(factory = {context->
     VideoView(context)
 })
 ```

### 原生控件中使用Compose

步骤如下:
1.在布局文件中添加ComposeView控件
```
<androidx.compose.ui.platform.ComposeView 
.....
/>
````
2.通过composeView.setContent函数来执行可组合函数

```
binding.composeView.setContent {
      #执行可组合函数#
}
```

### 主题

由于原生控件主题和Compose主题不同.
所以需要使Compose兼容现有的Theme.
步骤如下:
#1.添加依赖
```
implementation "com.google.android.material:compose-theme-adapter:$rootProject.composeVersion"
```

#2.使用MdcTheme包裹可组合函数
```
MdcTheme {
	#执行可组合函数#  
}
```

## 附带效应

### 简介

**Compose 中的附带效应是指发生在可组合函数作用域之外的应用状态的变化。**

原因:由于声明式UI的可组合函数，都是和state绑定的，当state发生变化时候，可组合函数都会发生重组，导致可组合函数都会重复执行，如果这时候在可组合参数中，执行了一些业务相关逻辑时候，会造成程序异常运行。例如以下：
```
1.写入共享对象的属性
2.更新ViewMdoel中的可观察项
3.更新共享偏好设置
```
解决:给Compose提供类似生命周期的Effect(附带效应),来保证在Compose中业务逻辑执行可预测.
```
1.LaunchedEffect：第一次调用Compose函数的时候调用
2.DisposableEffect：内部有一个onDispose函数，当页面推出时调用
3.SideEffect：compose函数每次执行都会调用该方法
```

### LaunchedEffect

LaunchedEffect:
1.第一次执行Compose函数的时候调用
2.当key发生变化的时候，会重新启动一个协程执行block。

示例:
```
LaunchedEffect(key1 = key1) {
	执行suspend函数或其他业务逻辑
}
```

### RememberCoroutineScope

LaunchedEffect是一个可组合函数，所以只能在可组合函数内使用。假如我们需要在可组合函数外启动协程，在可组合函数声明周期结束时候取消，可以使用rememberCoroutineScope。另外rememberCoroutineScope还可以控制多个协程。

示例代码:onClick方法是非可组合函数,这个时候就可以用rememberCoroutineScope.
```
val scope = rememberCoroutineScope()

IconButton(onClick = {
scope.launch { scaffoldState.drawerState.open()}
})
```

### RememberUpdateState

rememberUpdatedState:可以使LaunchedEffect的协程中，总是使用到最新的值，而不用重启协程。
```
val current by rememberUpdatedState(newValue = onTimeOut)
```

### DisposableEffect

DisposableEffect:也是一个可组合函数.
1.当DisposableEffect的key发生变化
或者组合函数离开组件树的时候调用block.
2.会取消之前启动的协程，同时会在取消协程前用其回收方法进行资源相关的回收，可以对一些资源进行清理。

示例代码:
```
DisposableEffect(key1 = Unit, effect = {
onDispose {
Toast.makeText(current, "DisposableHandle组合函数离开组件树", Toast.LENGTH_SHORT).show()
}
})
```

### SideEffect

SideEffect作用：
* 1.没有接受key值，所以每次重组，都会执行它的block。
* 2.主要用于与非Compose管理的对象共享Compose状态。
* 3.当组件被创建并且被载入组件树时候才会执行。

示例代码:
 ```
SideEffect {
   #执行内容#   
}
 ```

### ProduceState

ProduceState作用：
* 1.可以将非Compose状态转换为Compose状态，例如LiveData，Flow等等。
* 2.ProduceState创建了一个协程，但是也可以观察非挂起的数据源
* 3.当ProduceState进入Composition时候，获取数据的任务被启动，当其离开Composition时候，该任务被取消。

示例代码:
 ```
 @Composable
fun loadNetImage(url: String, imageRepository: ImageRepository): State<Result<ImageData>> {
  //1.创建produceState，默认值设置Loading。
    return produceState(initialValue = Result.Loading as Result<ImageData>, url, imageRepository) {
  //2.通过imageRepository.load，将url转化为drawable。
   val imageData = imageRepository.load(url)
  //3.通过设值给value，来更新State。
   value = if (imageData == null) 	{
     Result.Error
  } else {
  Result.Success(imageData)
 }
}
}

 ```

### DerivedState

DerivedState：如果某个状态是从其他状态对象计算或派生得出的，请使用derivedStateOf。作为条件
的状态我们称为条件状态。当任意一个条件状态更新时，结果状态都会重新计算。

示例代码:allTask是一个状态,而topTask是从allTask中派生出来的.
这个时候使用derivedStateOf,当allTask状态发生变化时候,topTask也会重新计算.
```
//列表数据集合
val allTask = remember { mutableStateListOf<String>() }
//当key值发生变化，topTask这个状态都会重新获取
val topTask = remember(key1 = allTask, key2 = top) {
  derivedStateOf {
      allTask.filter {
          top.contains(it)
       }
  }
}
```

## 常用的第三方库

### 图片加载

在Jetpack Compose中加载网络图片，使用 Coil这个库.
#1.引入Coli
```
implementation("io.coil-kt:coil:1.4.0")
```
#2.示例代码
```
AsyncImage(
            model = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png",
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop
)
```

### Accompanist

Accompanist 是一组库，旨在为Jetpack Compose补充开发人员通常需要但尚不可用的功能。

Accompanist 是一个类似实验室的环境，适用于新的 Compose API。我们使用它来帮助填补 Compose 工具包中的已知空白，试验新的 API，并收集有关开发 Compose 库的开发经验的见解。这些库的目标是将它们上游到官方工具包中，此时它们将被弃用并从 Accompanist 中删除。

网址:
https://google.github.io/accompanist/swiperefresh/
