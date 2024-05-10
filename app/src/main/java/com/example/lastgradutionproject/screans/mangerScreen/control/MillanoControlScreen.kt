package com.example.lastgradutionproject.screans.mangerScreen.control

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.screans.mangerScreen.design.DesignScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ControlScreen(navController: NavController) {
    val buttonClick = remember { mutableStateOf(false) }
    val control = remember {
        mutableStateOf(true)
    }
    if (control.value) {
        Scaffold(
            modifier = if (buttonClick.value) Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp) else Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            if (!buttonClick.value) {
                Column {
                    TopBar(control = control)
                    ControlBodyFirstPage(buttonClick = buttonClick)
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                ) {
                    Top_Bar(stay = buttonClick)
                    Column {
                        ControlBodySecondPage()
                    }
                }
            }
        }
    }
    else {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column {
                TopBar(control = control)
                DesignScreen(navController = navController)
            }
        }
    }
}


@Composable
fun TopBar(control: MutableState<Boolean>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Control",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .clickable { control.value = true },
            color = if (control.value) Color(0xFFAA6145) else Color.DarkGray
        )

        Text(
            text = "Designs",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .clickable { control.value = false },
            color = if (!control.value) Color(0xFFAA6145) else Color.DarkGray
        )
    }
}

@Composable
fun ControlBodyFirstPage(buttonClick: MutableState<Boolean>) {
    val manState = remember { mutableStateOf(false) }
    val womanState = remember { mutableStateOf(false) }
    val kidsState = remember { mutableStateOf(false) }
    val shoesState = remember { mutableStateOf(false) }
    val amount = rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val piece = remember { mutableIntStateOf(0) }
    val totalPrice = remember { mutableDoubleStateOf(0.0) }
    val sliderValue = rememberSaveable { mutableFloatStateOf(0f) }
    val summerState = remember { mutableStateOf(false) }
    val springState = remember { mutableStateOf(false) }
    val autumnState = remember { mutableStateOf(false) }
    val winterState = remember { mutableStateOf(false) }
    Column {
        TotalPrice(totalPrice = totalPrice.doubleValue)
        TextTitle(text = "Types")
        CheckBoxes(
            valueState1 = manState,
            valueState2 = kidsState,
            valueState3 = womanState,
            valueState4 = shoesState,
            value1 = "Men",
            value2 = "Kids",
            value3 = "Woman",
            value4 = "Shoes and Bags"
        )
        TextTitle(text = "Enter Amount")
        OutlinedTextField(value = amount.value,
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                if (it.isNotEmpty()) {
                    if (Integer.parseInt(it) <= 1000) {
                        amount.value = it.trim()
                        sliderValue.floatValue = (amount.value.toFloat() * 100) / 1000
                        totalPrice.doubleValue = amount.value.toDouble() * 10
                    }
                } else {
                    amount.value = ""
                    totalPrice.doubleValue = 0.0
                }
            },
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions {
                keyboardController?.hide()
                if (amount.value.isNotEmpty()) sliderValue.floatValue =
                    (amount.value.toFloat() * 100) / 1000
                totalPrice.doubleValue = amount.value.toDouble() * 10
            })
        PieceRow(price = piece)
        SliderButton(sliderValue = sliderValue)
        TextTitle(text = "Collection")
        CheckBoxes(
            valueState1 = summerState,
            valueState2 = autumnState,
            valueState3 = springState,
            valueState4 = winterState,
            value1 = "Summer",
            value2 = "Autumn",
            value3 = "Spring",
            value4 = "Winter"
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Button(
                onClick = {
                    buttonClick.value = true
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1c4652)
                )
            ) {
                Text(
                    text = "Next", style = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(start = 5.dp)
                )
            }
        }
    }
}

@Composable
fun ControlBodySecondPage() {
    val smallState = remember { mutableStateOf(false) }
    val mediumState = remember { mutableStateOf(false) }
    val largeState = remember { mutableStateOf(false) }
    val xlargeState = remember { mutableStateOf(false) }
    val xxlargeState = remember { mutableStateOf(false) }
    val xxxlargeState = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        TextTitle(text = "Sizes")
        SizeCheckBox(
            smallState = smallState,
            mediumState = mediumState,
            largeState = largeState,
            xLargeState = xlargeState,
            xxLargeState = xxlargeState,
            xxxLargeState = xxxlargeState
        )
        Spacer(modifier = Modifier.height(50.dp))
        TextTitle(text = "Color")
        ColorBox()
        Spacer(modifier = Modifier.height(80.dp))
        TextTitle(text = "Brand")
        BrandForm()
    }

}

//Control1

@Composable
fun TotalPrice(totalPrice: Double = 0.0) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(top = 12.dp)
            .clip(shape = CircleShape.copy(all = CornerSize(12.dp))), color = Color(0xFFAA6145)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Total Price", style = TextStyle(
                    color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            val total = "%.2f".format(totalPrice)
            Text(
                text = "\$$total", style = TextStyle(
                    color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
            )


        }

    }

}

@Composable
fun CheckBoxes(
    valueState1: MutableState<Boolean>,
    valueState2: MutableState<Boolean>,
    valueState3: MutableState<Boolean>,
    valueState4: MutableState<Boolean>,
    value1: String,
    value2: String,
    value3: String,
    value4: String,
//    manClicked: () -> Unit,
//    womanClicked: () -> Unit,
//    kidsClicked: () -> Unit,
//    shoesClicked: () -> Unit,
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = valueState1.value, onCheckedChange = { valueState1.value = it })
                Text(text = value1)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = valueState2.value, onCheckedChange = { valueState2.value = it })
                Text(text = value2)
            }
        }
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = valueState3.value, onCheckedChange = { valueState3.value = it })
                Text(text = value3)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = valueState4.value, onCheckedChange = { valueState4.value = it })
                Text(text = value4)
            }
        }
    }
}

@Composable
fun PieceRow(price: MutableIntState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Piece", style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
            ), modifier = Modifier.padding(start = 5.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {
                if (price.intValue > 0) price.intValue--
                else price.intValue = 0
            }) {

                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = "Minus",
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(
                text = "${price.intValue}", style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.SemiBold
                )
            )
            IconButton(onClick = {
                price.intValue++
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = "Add",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun SliderButton(sliderValue: MutableState<Float>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "${sliderValue.value.toInt()}%")
        Slider(
            value = sliderValue.value, onValueChange = {
                sliderValue.value = it
            }, valueRange = 1f..100f, enabled = false, colors = SliderDefaults.colors(
                thumbColor = Color(0xffa9837f),
                activeTrackColor = Color(0xffa9837f),
                activeTickColor = Color(0xffa9837f),
                inactiveTrackColor = Color(0xffa9837f),
                inactiveTickColor = Color(0xffa9837f),
                disabledThumbColor = Color(0xffa9837f),
                disabledActiveTrackColor = Color(0xffa9837f),
                disabledActiveTickColor = Color(0xffa9837f),
                disabledInactiveTrackColor = Color(0xffa9837f),
                disabledInactiveTickColor = Color(0xffa9837f)
            )
        )
    }
}


@Composable
fun TextTitle(text: String) {
    Text(
        text = text,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
    )
}

// Control2

@Composable
fun Top_Bar(stay: MutableState<Boolean>) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFFAA6145)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                stay.value = false
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }

        }
    }
}

@Composable
fun SizeCheckBox(
    smallState: MutableState<Boolean>,
    mediumState: MutableState<Boolean>,
    largeState: MutableState<Boolean>,
    xLargeState: MutableState<Boolean>,
    xxLargeState: MutableState<Boolean>,
    xxxLargeState: MutableState<Boolean>,
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = smallState.value, onCheckedChange = { smallState.value = it })
                Text(text = "S")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = xLargeState.value, onCheckedChange = { xLargeState.value = it })
                Text(text = "XL")
            }
        }
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = mediumState.value, onCheckedChange = { mediumState.value = it })
                Text(text = "M")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = xxLargeState.value,
                    onCheckedChange = { xxLargeState.value = it })
                Text(text = "2XL")
            }
        }
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = largeState.value, onCheckedChange = { largeState.value = it })
                Text(text = "L")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = xxxLargeState.value,
                    onCheckedChange = { xxxLargeState.value = it })
                Text(text = "3XL")
            }
        }
    }
}


@Composable
fun ColorBox() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(20.dp),
            shape = RectangleShape,
            border = BorderStroke(1.dp, color = Color.DarkGray),
            color = Color.Red
        ) {}
        Surface(
            modifier = Modifier.size(20.dp),
            shape = RectangleShape,
            border = BorderStroke(1.dp, color = Color.DarkGray),
            color = Color.Blue
        ) {}
        Surface(
            modifier = Modifier.size(20.dp),
            shape = RectangleShape,
            border = BorderStroke(1.dp, color = Color.DarkGray),
            color = Color.Green
        ) {}
        Surface(
            modifier = Modifier.size(20.dp),
            shape = RectangleShape,
            border = BorderStroke(1.dp, color = Color.DarkGray),
            color = Color.Yellow
        ) {}
        Surface(
            modifier = Modifier.size(20.dp),
            shape = RectangleShape,
            border = BorderStroke(1.dp, color = Color.DarkGray),
            color = Color(0xffd836c8)
        ) {}
        Surface(
            modifier = Modifier.size(20.dp),
            shape = RectangleShape,
            border = BorderStroke(1.dp, color = Color.DarkGray),
            color = Color(0xffb2e9e7)
        ) {}
        Surface(
            modifier = Modifier.size(20.dp),
            shape = RectangleShape,
            border = BorderStroke(1.dp, color = Color.DarkGray),
            color = Color(0xffa9839f)
        ) {}
    }

}

@Composable
fun BrandForm() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val puma = remember { mutableStateOf(false) }
            val dg = remember { mutableStateOf(false) }
            val chanel = remember { mutableStateOf(false) }
            BrandButtons(text = "PUMA", selected = puma)
            Spacer(modifier = Modifier.width(20.dp))
            BrandButtons(text = "D&G", selected = dg)
            Spacer(modifier = Modifier.width(20.dp))
            BrandButtons(text = "CHANEL", selected = chanel)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val boss = remember { mutableStateOf(false) }
            val adidas = remember { mutableStateOf(false) }
            val ck = remember { mutableStateOf(false) }
            BrandButtons(text = "BOOS", selected = boss)
            Spacer(modifier = Modifier.width(20.dp))
            BrandButtons(text = "ADIDAS", selected = adidas)
            Spacer(modifier = Modifier.width(20.dp))
            BrandButtons(text = "CK", selected = ck)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val lacoste = remember { mutableStateOf(false) }
            val gap = remember { mutableStateOf(false) }
            val lost = remember { mutableStateOf(false) }
            BrandButtons(text = "LACOSTE", selected = lacoste)
            Spacer(modifier = Modifier.width(20.dp))
            BrandButtons(text = "GAP", selected = gap)
            Spacer(modifier = Modifier.width(20.dp))
            BrandButtons(text = "LOST", selected = lost)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val shein = remember { mutableStateOf(false) }
            val dior = remember { mutableStateOf(false) }
            BrandButtons(text = "SHE IN", selected = shein)
            Spacer(modifier = Modifier.width(20.dp))
            BrandButtons(text = "DIOR", selected = dior)
        }
    }
}

@Composable
fun BrandButtons(text: String, selected: MutableState<Boolean>) {

    Button(
        onClick = { selected.value = !selected.value }, colors = ButtonDefaults.buttonColors(
            containerColor = if (selected.value) Color.DarkGray else Color.LightGray
        )
    ) {
        Text(
            text = text,
            color = if (selected.value) Color.White else Color.Black
        )
    }
}