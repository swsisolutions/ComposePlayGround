package swasi.android.play.youtubeTutor.list

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import swasi.android.play.R
import swasi.android.play.youtubeTutor.list.ListConstants.countryList
import swasi.android.play.youtubeTutor.list.ListConstants.fruitsList

class ListExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListExample()
        }
    }
}

@Composable
fun ListExample() {

    var visibleWidget by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
    ) {

        Column(Modifier.weight(0.2f)) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { visibleWidget = ListConstants.ROW }
                ) {
                    Text(text = ListConstants.ROW, fontSize = 14.sp)
                }

                Button(onClick = { visibleWidget = ListConstants.LAZY_ROW }
                ) {
                    Text(text = ListConstants.LAZY_ROW, fontSize = 14.sp)
                }
                Button(onClick = { visibleWidget = ListConstants.CUSTOM_LAZY_ROW }
                ) {
                    Text(text = ListConstants.CUSTOM_LAZY_ROW, fontSize = 10.sp)
                }
            }

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { visibleWidget = ListConstants.COLUMN },
                    Modifier.weight(3.0f)
                ) {
                    Text(text = ListConstants.COLUMN, fontSize = 10.sp)
                }

                Button(
                    onClick = { visibleWidget = ListConstants.LAZY_COLUMN },
                    Modifier.weight(3.0f)
                ) {
                    Text(text = ListConstants.LAZY_COLUMN, fontSize = 8.sp)
                }
                Button(
                    onClick = { visibleWidget = ListConstants.CUSTOM_LAZY_COLUMN },
                    Modifier.weight(4.0f)
                ) {
                    Text(text = ListConstants.CUSTOM_LAZY_COLUMN, fontSize = 8.sp)
                }
            }
        }

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
        ) {
            RowColumnScreen(visibleWidget)
        }
    }
}

@Composable
fun RowColumnScreen(visibleWidget: String) {
    when (visibleWidget) {

        ListConstants.COLUMN, ListConstants.ROW -> {
            RowColumnView(visibleWidget)
        }

        ListConstants.LAZY_ROW, ListConstants.LAZY_COLUMN -> {
            ListView(visibleWidget)
        }

        ListConstants.CUSTOM_LAZY_ROW, ListConstants.CUSTOM_LAZY_COLUMN -> {
            CustomListView(visibleWidget)
        }

        else -> {
            Text(
                text = "NOTHING SELECTED",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun ListExamplePreview() {
    ListExample()
}

@Composable
fun RowColumnView(type: String) {
    val scrollState = rememberScrollState()
    when (type) {
        ListConstants.COLUMN -> {
            val context = LocalContext.current
            Column(
                Modifier
                    .verticalScroll(scrollState)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (i in 1..50) {
                    var enabled by remember { mutableStateOf(true) }

                    ClickableText(
                        text = AnnotatedString("Item $i"),
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .background(
                                color = Color.Gray,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(10.dp),
                        onClick = {
                            Toast.makeText(context, "Clicked Item $i", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }

        ListConstants.ROW -> {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                Modifier.horizontalScroll(scrollState),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 1..50) {
                    Text(
                        text = "Item $i",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.Green,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color.Gray,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(10.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                }
            }
        }
    }
}

@Composable
fun ListView(type: String) {
    val listModifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(10.dp)

    val textStyle = TextStyle(fontSize = 20.sp, color = Color.White)

    if (type == ListConstants.LAZY_ROW) {
        LazyRow(
            modifier = listModifier.padding(2.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(countryList) { country ->
                SimpleLazyListItem(text = country, textStyle = textStyle)
            }
        }
    } else {
        LazyColumn(
            modifier = listModifier.padding(2.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(countryList) { country ->
                SimpleLazyListItem(text = country, textStyle = textStyle)
            }
        }
    }
}

@Composable
fun SimpleLazyListItem(text: String, textStyle: TextStyle) {
    val context = LocalContext.current
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = Color.Green,
        style = textStyle,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp)
            .clickable(enabled = true) {
                Toast
                    .makeText(context, "Clicked $text", Toast.LENGTH_SHORT)
                    .show()
            }
    )
    Spacer(modifier = Modifier.width(20.dp))
}

@Composable
fun CustomListView(type: String) {
    val context = LocalContext.current
    if (type == ListConstants.CUSTOM_LAZY_ROW) {
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(fruitsList) { index, model ->
                ListColumn(model = model)
            }
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(fruitsList) { model ->
                ListRow(model = model) {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

data class FruitModel(val name: String, val image: Int)

@Composable
fun ListRow(model: FruitModel, onClick: (msg: String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable { onClick(model.name) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(
                    color = Color.Gray,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = model.image),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp)
            )
            Text(
                text = model.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

@Composable
fun ListColumn(model: FruitModel) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp)
            .clickable(enabled = true) {
                Toast
                    .makeText(context, "Clicked ${model.name}", Toast.LENGTH_SHORT)
                    .show()
            }
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

object ListConstants {
    const val ROW = "Row"
    const val LAZY_ROW = "LazyRow"
    const val CUSTOM_LAZY_ROW = "CustomLazyRow"
    const val COLUMN = "Column"
    const val LAZY_COLUMN = "LazyColumn"
    const val CUSTOM_LAZY_COLUMN = "CustomLazyColumn"

    val countryList = mutableListOf(
        "Afghanistan",
        "Albania",
        "Algeria",
        "American Samoa",
        "Andorra",
        "Angola",
        "Anguilla",
        "Antarctica",
        "Antigua and Barbuda",
        "Argentina",
        "Armenia",
        "Aruba",
        "Australia",
        "Austria",
        "Azerbaijan",
        "Bahamas",
        "Bahrain",
        "Bangladesh",
        "Barbados",
        "Belarus",
        "Belgium",
        "Belize",
        "Benin",
        "Bermuda",
        "Bhutan",
        "Bolivia",
        "Bosnia and Herzegowina",
        "Botswana",
        "Bouvet Island",
        "Brazil",
        "British Indian Ocean Territory",
        "Brunei Darussalam",
        "Bulgaria",
        "Burkina Faso",
        "Burundi",
        "Cambodia",
        "Cameroon",
        "Canada",
        "Cape Verde",
        "Cayman Islands",
        "Central African Republic",
        "Chad",
        "Chile",
        "China",
        "Christmas Island",
        "Cocos (Keeling) Islands",
        "Colombia",
        "Comoros",
        "Congo",
        "Congo, the Democratic Republic of the",
        "Cook Islands",
        "Costa Rica",
        "Cote d'Ivoire",
        "Croatia (Hrvatska)",
        "Cuba",
        "Cyprus",
        "Czech Republic",
        "Denmark",
        "Djibouti",
        "Dominica",
        "Dominican Republic",
        "East Timor",
        "Ecuador",
        "Egypt",
        "El Salvador",
        "Equatorial Guinea",
        "Eritrea",
        "Estonia",
        "Ethiopia",
        "Falkland Islands (Malvinas)",
        "Faroe Islands",
        "Fiji",
        "Finland",
        "France",
        "France Metropolitan",
        "French Guiana",
        "French Polynesia",
        "French Southern Territories",
        "Gabon",
        "Gambia",
        "Georgia",
        "Germany",
        "Ghana",
        "Gibraltar",
        "Greece",
        "Greenland",
        "Grenada",
        "Guadeloupe",
        "Guam",
        "Guatemala",
        "Guinea",
        "Guinea-Bissau",
        "Guyana",
        "Haiti",
        "Heard and Mc Donald Islands",
        "Holy See (Vatican City State)",
        "Honduras",
        "Hong Kong",
        "Hungary",
        "Iceland",
        "India",
        "Indonesia",
        "Iran (Islamic Republic of)",
        "Iraq",
        "Ireland",
        "Israel",
        "Italy",
        "Jamaica",
        "Japan",
        "Jordan",
        "Kazakhstan",
        "Kenya",
        "Kiribati",
        "Korea, Democratic People's Republic of",
        "Korea, Republic of",
        "Kuwait",
        "Kyrgyzstan",
        "Lao, People's Democratic Republic",
        "Latvia",
        "Lebanon",
        "Lesotho",
        "Liberia",
        "Libyan Arab Jamahiriya",
        "Liechtenstein",
        "Lithuania",
        "Luxembourg",
        "Macau",
        "Macedonia, The Former Yugoslav Republic of",
        "Madagascar",
        "Malawi",
        "Malaysia",
        "Maldives",
        "Mali",
        "Malta",
        "Marshall Islands",
        "Martinique",
        "Mauritania",
        "Mauritius",
        "Mayotte",
        "Mexico",
        "Micronesia, Federated States of",
        "Moldova, Republic of",
        "Monaco",
        "Mongolia",
        "Montserrat",
        "Morocco",
        "Mozambique",
        "Myanmar",
        "Namibia",
        "Nauru",
        "Nepal",
        "Netherlands",
        "Netherlands Antilles",
        "New Caledonia",
        "New Zealand",
        "Nicaragua",
        "Niger",
        "Nigeria",
        "Niue",
        "Norfolk Island",
        "Northern Mariana Islands",
        "Norway",
        "Oman",
        "Pakistan",
        "Palau",
        "Panama",
        "Papua New Guinea",
        "Paraguay",
        "Peru",
        "Philippines",
        "Pitcairn",
        "Poland",
        "Portugal",
        "Puerto Rico",
        "Qatar",
        "Reunion",
        "Romania",
        "Russian Federation",
        "Rwanda",
        "Saint Kitts and Nevis",
        "Saint Lucia",
        "Saint Vincent and the Grenadines",
        "Samoa",
        "San Marino",
        "Sao Tome and Principe",
        "Saudi Arabia",
        "Senegal",
        "Seychelles",
        "Sierra Leone",
        "Singapore",
        "Slovakia (Slovak Republic)",
        "Slovenia",
        "Solomon Islands",
        "Somalia",
        "South Africa",
        "South Georgia and the South Sandwich Islands",
        "Spain",
        "Sri Lanka",
        "St. Helena",
        "St. Pierre and Miquelon",
        "Sudan",
        "Suriname",
        "Svalbard and Jan Mayen Islands",
        "Swaziland",
        "Sweden",
        "Switzerland",
        "Syrian Arab Republic",
        "Taiwan, Province of China",
        "Tajikistan",
        "Tanzania, United Republic of",
        "Thailand",
        "Togo",
        "Tokelau",
        "Tonga",
        "Trinidad and Tobago",
        "Tunisia",
        "Turkey",
        "Turkmenistan",
        "Turks and Caicos Islands",
        "Tuvalu",
        "Uganda",
        "Ukraine",
        "United Arab Emirates",
        "United Kingdom",
        "United States",
        "United States Minor Outlying Islands",
        "Uruguay",
        "Uzbekistan",
        "Vanuatu",
        "Venezuela",
        "Vietnam",
        "Virgin Islands (British)",
        "Virgin Islands (U.S.)",
        "Wallis and Futuna Islands",
        "Western Sahara",
        "Yemen",
        "Yugoslavia",
        "Zambia",
        "Zimbabwe",
        "Palestine"
    )

    val fruitsList = mutableListOf<FruitModel>(
        FruitModel("Apple", R.drawable.apple),
        FruitModel("Banana", R.drawable.banana),
        FruitModel("Orange", R.drawable.orange),
        FruitModel("Strawberry", R.drawable.strawberry),
        FruitModel("Mango", R.drawable.mango),
        FruitModel("pomegranate", R.drawable.pomegranate),
        FruitModel("Grapes", R.drawable.grapes),
        FruitModel("Avocado", R.drawable.avocado),
        FruitModel("Pears", R.drawable.pears),
        FruitModel("Kiwi", R.drawable.kiwi),
        FruitModel("Jack fruit", R.drawable.jackfruit),
        FruitModel("Pine Apple", R.drawable.pineapple)
    )
}