# Youtube tutorial Notes

- https://www.youtube.com/watch?v=gxWcfz3V2QE&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=10

# Constraint Layout
- We can use Constraint Layout Jetpack Compose
- We can arrange child widgets using Row and column, but we can also do it by using Constraint
  Layout

## Compose Constraint Layout Properties
- ConstraintSet
- createRefFor
- linkTo
- Dimension.value(100.dp)
- createGuidelineFromTop
- constrain(createRefFor id)

# Jetpack Compose Effect Handlers
- https://developer.android.com/jetpack/compose/side-effects
- EffectHandlersTheme
- LaunchedEffect
- rememberCoroutineScope
- rememberUpdatedState
- DisposableEffect
```
private var i = 0;
setContent{
    vsr textt by remember {
        mutableStateOf("")
    }
    EffectHandlersTheme{
        Button(onClcik ={text += "#"}){
            i++
            Text(text = text)
        }
    }
}
```

- In this above block of code, we are doing some non compose operation inside compose scope
- So, whenever the text value changes, the value of i will be increase, which should not be the
  case.
- Lets consider, instead of i, if we make a network call, then whenever tthe compose recomposes,
  then the network call will happen
- But we don't want to make the network call whenever the Button Recomposes
- To avoid this we can use effect handlers
- The above scenario is never recommended to do.

## LaunchedEffect
- Look into the example ComposeEffectActivity.kt file
- Find all the side Effect things in
  the [Video](https://www.youtube.com/watch?v=gxWcfz3V2QE&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=10)

# Animation
