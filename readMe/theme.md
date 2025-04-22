# Themes in Jetpack Compose
- If you create a new Jetpack compose project, you will see ui.theme package. It contains the following classes.
- **Color.kt**  - for custom colors
- **Shape.kt** - for custom shapes 
- **Type.kt** - for custom typography 
- **Theme.kt** - for custom themes
## Material Theme
- A Material Theme defines the styling principles from the Material Design specification. 
- In Jetpack Compose, MaterialTheme is available as a composable function with which we can customize the default attributes.
```
MaterialTheme(
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
)
```
- The Material Design components (buttons, cards, switches, and so on) are built on top of Material Theming, which is a systematic way to customize Material Design to better reflect your product’s brand. 
- A Material Theme comprises color, typography and shape attributes. When you customize these attributes, it automatically reflected your changes in the components.

- Follow this **https://www.jetpackcompose.net/themes-in-jetpack-compose**

## 1.Colors
- In Color.kt
```
    val Purple200 = Color(0xFFBB86FC)
    val Teal200 = Color(0xFF03DAC5)
    //you can add your own color here
```
- First two characters 0x tell the compiler that this is a hexadecimal number. 
- Second two characters, "FF" represent Transparency/Alpha in Hex. 
- The remaining six character pairs represent Red, Green, and Blue. 

## 2.Typography (Font style)
- Material theme Typography class has some default text styles.
```
class Typography(
    defaultFontFamily: FontFamily = FontFamily.Default,
    h1: TextStyle,
    h2: TextStyle,
    h3: TextStyle,
    h4: TextStyle,
    h5: TextStyle,
    h6: TextStyle,
    subtitle1: TextStyle,
    subtitle2: TextStyle,
    body1: TextStyle,
    body2: TextStyle,
    button: TextStyle,
    caption: TextStyle,
    overline: TextStyle
)
```
- You can either add new text styles or customize the existing text styles.

## 2a. How to override/customize default Textstyles?
- In Type.kt
- (Class doesn't matter. But we should keep in the same class for code maintenance)
- Step 1: Create custom typography
```
val MyCustomTypography = Typography(
    body1 = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Normal,
    fontSize = 18.sp
    )
    //you can override other text styles here. Like this,
    subtitle1 = TextStyle(....)
)
```
- Step 2: Apply this typography in MaterialTheme
```
MaterialTheme(
    ....
    typography = MyCustomTypography,
    ....
)
```
- Step 3: Use it in your widgets
```
Text(
    text = "Customized TextStyle (Body1) ",
    style = MaterialTheme.typography.body1
)
```
## 2b. How to add new text styles in material theme?
- In Type.kt
- Step 1: Add a new text style in material theme typography
- You need to use kotlin extension function.
- import androidx.compose.material.Typography
```
val Typography.customTitle: TextStyle
@Composable
get() {
    return  TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    )
}
```
- Step 2: Use it in your widgets
```
    Text(text = "Custom", style = MaterialTheme.typography.customTitle)
```

## 2c. How to use custom font ?
- Step 1: Create font folder
- In your res folder  -> Create a new folder named "font"
- Step 2:  Paste your font files
- Download your fonts and paste it into "font" folder.
- I use nexa fonts, one regular and another one bold.
- Step 3: Create fontFamily variable
- Create a variable for fontFamily. You can use it directly, but re-usable purpose I created fontFamily variable.
```
val NexaFont = FontFamily(
    Font(R.font.nexa_regular,FontWeight.Normal),
    Font(R.font.nexa_bold,FontWeight.Bold)
)
```
- Note: If you add same font weight multiple times, it will throw run time error.
```
val NexaFontInvalidSample = FontFamily(
    Font(R.font.nexa_regular,FontWeight.Normal),
    Font(R.font.nexa_bold,FontWeight.Normal)// this is invalid if you add same font weight second time.
)
```
- Step 4: Set fontFamily in your TextStyle
- Set this fontFamily in your typography and apply this typography into your theme.
```
val Typography = Typography(

    subtitle1 = TextStyle(
        fontFamily = NexaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = NexaFont,
        fontSize = 20.sp,
    )
)
```
- Step 5: Use it in your widgets

```
    Text(text = "Nexa bold",
    style = MaterialTheme.typography.subtitle1)//bold
    Text(text = "Nexa regular",
    style = MaterialTheme.typography.subtitle2)//regular
```

## 3. Set Dark and Light theme
- Step 1: Create color set for dark & light themes
- Jetpack Compose provides two default functions:
```
darkColors(...)  - for DarkMode
lightColors(...)  - for LightMode
```
- We can override each of the colors easily, by providing them accordingly
```
private val DarkColorPalette = darkColors(
    primary = Color.Black,
    primaryVariant = Color.Black,
    secondary = Color.LightGray,
    //surface = Color.Gray,
)
```
```
private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)
```
- Note: Apply these changes in Theme.kt file.
- Step 2: Create a custom theme
```
@Composable
fun MyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit ) {
val colors = if (darkTheme) {
    DarkColorPalette
} else {
    LightColorPalette
}

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
```
- Here we add the condition,
- if it's darkTheme we use DarkColorPalette else we use the LightColorPalette.
- Step 3: Wrap your composable function inside this theme
```
val isDarkTheme = remember { mutableStateOf(false) }

MyAppTheme(darkTheme = isDarkTheme.value) {
    //your composable function
    //you can switch dark theme easily.
    Just update the value --> isDarkTheme.value = true
}
```