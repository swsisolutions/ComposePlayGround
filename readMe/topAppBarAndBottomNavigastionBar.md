# TopAppBar and Bottom Navigation with Scaffold 
- https://www.jetpackcompose.net/scaffold
## What's Scaffold?
- It allows you to implement a UI with the basic Material Design layout structure.
- You can add the following widgets with the help of Scaffold,
- TopAppBar (Toolbar)
- Floating Action Button (FAB)
- Drawer Menu
- Bottom Navigation
- Structure of Scaffold:
```
Scaffold(
    topBar = { //your top bar  },
    floatingActionButton = {//your floating action button},
    drawerContent = { //drawer content },
    content = { //your page content},
    bottomBar = { //your bottom bar composable }
)
```
-  Simple example:
```
@Composable
fun ScaffoldSample() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = {Text("Top App Bar")},backgroundColor = MaterialTheme.colors.primary)  },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
                Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
        } },
        drawerContent = { Text(text = "Drawer Menu 1") },
        content = { Text("Content") },
        bottomBar = { BottomAppBar(backgroundColor = MaterialTheme.colors.primary) { Text("Bottom App Bar") } }
    )
}
```
We add the topBar, floatingActionButton, drawer, bottomBar.
