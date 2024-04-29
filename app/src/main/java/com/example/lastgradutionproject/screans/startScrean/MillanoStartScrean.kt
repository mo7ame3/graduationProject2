package com.example.lastgradutionproject.screans.startScrean

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans

@Composable
fun StartScrean(navController: NavController,
                loading:Boolean=false,
                isCreatAcount:Boolean=false,
                onDone:(String,String,String) -> Unit = {name,country,gender -> }
                ){
    val Name= rememberSaveable {
        mutableStateOf("")

    }
    val Country= rememberSaveable {
        mutableStateOf("")

    }
    val Gender= rememberSaveable {
        mutableStateOf("")

    }
    val passwordFocusRequest=FocusRequester.Default
    val keyboardController= LocalSoftwareKeyboardController.current
    val valid= remember (Name.value,Country.value,Gender.value){
        Name.value.trim().isNotEmpty()&&  Country.value.trim().isNotEmpty() && Gender.value.trim().isNotEmpty()

    }


    Card (modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .fillMaxSize(),
        colors = CardDefaults.cardColors(colorResource(id = R.color.Brown))
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(500.dp)
                .padding(1.dp, bottom = 30.dp),
            painter = painterResource(id = R.drawable.img_3), contentDescription = ""
        )
        Column(
            modifier = Modifier.padding(top = 60.dp, start = 9.dp),
            verticalArrangement = Arrangement.Bottom) {
            Text(text = "Explor", fontSize = 26.sp, fontWeight = FontWeight.Bold,
                color = Color.White)
            Text(text = "Modern Clothes", fontSize = 26.sp, fontWeight = FontWeight.Bold,
                color = Color.White)
            Spacer(modifier = Modifier.height(15.dp))

            Card (modifier = Modifier
                .width(107.dp)
                .height(8.dp),
                shape = RoundedCornerShape(4.dp)

            ){

            }
            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Discover Your Style", fontSize = 19.sp, fontWeight = FontWeight.SemiBold,
                color = Color.White)


        }

    }
    Text(
        text = " Welcome Enter Your Information",
        fontSize = 21.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier=Modifier.padding(start = 22.dp, top = 30.dp)
    )
    Column (modifier = Modifier.padding(top = 65.dp)){
        Name(navController = navController, nameState = Name, enabled = !loading, onAction = KeyboardActions{
            passwordFocusRequest.requestFocus()
        })
        Spacer(modifier = Modifier.height(10.dp))

        Country(navController = navController, countryState = Country, enabled = !loading,
            onAction = KeyboardActions{ passwordFocusRequest.requestFocus() }
        )
        Spacer(modifier = Modifier.height(10.dp))

        Gender(navController = navController, genderState = Gender, enabled = !loading,
            onAction = KeyboardActions{
               // passwordFocusRequest.requestFocus()
                if (!valid) return@KeyboardActions
                onDone( Name.value.trim(),  Country.value.trim(), Gender.value.trim()) })
        Spacer(modifier = Modifier.height(59.dp))
        SelectButton(
            //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
            loading =loading,
            validInputs =valid
        ){
            onDone( Name.value.trim(),  Country.value.trim(), Gender.value.trim())
            navController.navigate(MillanoScreans.LoginScrean.name)

        }

        Text(text = "Skip", fontWeight = FontWeight.Bold,
            fontSize = 21.sp,
            modifier = Modifier.padding(top = 59.dp, start = 320.dp)
                .clickable {
                    navController.navigate(MillanoScreans.LoginScrean.name)

                },
            color = Color.White
        )


    }


}

@Composable
fun SelectButton(
    //textId: Unit ,
    loading: Boolean,
    validInputs: Boolean,
    onClick: () -> Unit) {
    Button(          onClick=onClick,
        modifier = Modifier
            .width(350.dp)
            .height(45.dp)
            .padding(start = 48.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "Select", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
       // else Text(text = textId, modifier = Modifier.padding(5.dp))
    }

}


@Composable
fun Name(navController: NavController,
         modifier:Modifier=Modifier,
         nameState:MutableState<String>,
         labelId:String="Enter your Name",
         enabled:Boolean=true,
         imeAction:ImeAction= ImeAction.Next,
         onAction:KeyboardActions=KeyboardActions.Default,
         ){
    nameFailed( navController=navController,
        modifier=Modifier,
        nameState=nameState
        ,labelId=labelId,
        enabled=enabled
        ,imeAction=imeAction,
        keyboardType= KeyboardType.Text,
        onAction=onAction)

}
@Composable
fun Country(navController: NavController,
            modifier:Modifier=Modifier,
            countryState: MutableState<String>,
            labelId:String="Country",
            enabled:Boolean=true,
            imeAction:ImeAction= ImeAction.Next,
            onAction:KeyboardActions=KeyboardActions.Default,
){
    countryFailed( navController=navController,
        modifier=Modifier,
        countryState = countryState,
        labelId=labelId,
        enabled=enabled
        ,imeAction=imeAction,
        keyboardType= KeyboardType.Text,
        onAction=onAction)

}

@Composable
fun Gender(navController: NavController,
         modifier:Modifier=Modifier,
         genderState:MutableState<String>,
         labelId:String="Gender",
         enabled:Boolean=true,
         imeAction:ImeAction= ImeAction.Next,
         onAction:KeyboardActions=KeyboardActions.Default,
){
    GenderFailed( navController=navController,
        modifier=Modifier,
        genderState  = genderState ,
        labelId=labelId,
        enabled=enabled,
        imeAction=imeAction,
        keyboardType= KeyboardType.Text,
        onAction=onAction)

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun nameFailed(
    navController: NavController,
    modifier:Modifier=Modifier,
    nameState:MutableState<String>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType=KeyboardType.Text,
    imeAction:ImeAction= ImeAction.Next,
    onAction:KeyboardActions=KeyboardActions.Default,
) {
    OutlinedTextField(
        value = nameState.value,
        onValueChange = { nameState.value =it},
        modifier= Modifier
            .padding(start = 22.dp, end = 22.dp)
            .fillMaxWidth(),
        label = {Text(text = labelId) },
        enabled = enabled, singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction, textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            cursorColor = colorResource(id = R.color.Brown),
            // textColor = colorResource(id = R.color.Brown),
            // leadingIconColor = colorResource(id = R.color.Brown),
            //trailingIconColor = colorResource(id = R.color.Brown),
            errorCursorColor = colorResource(id = R.color.Brown),
            errorLeadingIconColor = colorResource(id = R.color.Brown),
            errorTrailingIconColor = colorResource(id = R.color.Brown),
            errorTextColor = colorResource(id = R.color.Brown),
            errorBorderColor = colorResource(id = R.color.Brown),
        ),
       //
        //BorderStroke(width = 5.dp, color = Color.Black)
    )

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun countryFailed(
    navController: NavController,
    modifier:Modifier=Modifier,
    countryState:MutableState<String>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType=KeyboardType.Text,
    imeAction:ImeAction= ImeAction.Next,
    onAction:KeyboardActions=KeyboardActions.Default,
) {
    OutlinedTextField(
        value = countryState.value,
        onValueChange = { countryState.value=it },
        modifier= Modifier
            .padding(start = 22.dp, end = 22.dp)
            .fillMaxWidth(),
        label = {Text(text = labelId) },
        enabled = enabled, singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction, textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            cursorColor = colorResource(id = R.color.Brown),
            // textColor = colorResource(id = R.color.Brown),
            // leadingIconColor = colorResource(id = R.color.Brown),
            //trailingIconColor = colorResource(id = R.color.Brown),
            errorCursorColor = colorResource(id = R.color.Brown),
            errorLeadingIconColor = colorResource(id = R.color.Brown),
            errorTrailingIconColor = colorResource(id = R.color.Brown),
            errorTextColor = colorResource(id = R.color.Brown),
            errorBorderColor = colorResource(id = R.color.Brown),
        ),
        //
        //BorderStroke(width = 5.dp, color = Color.Black)
    )

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderFailed(
    navController: NavController,
    modifier:Modifier=Modifier,
    genderState:MutableState<String>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType=KeyboardType.Text,
    imeAction:ImeAction= ImeAction.Next,
    onAction:KeyboardActions=KeyboardActions.Default,
) {
    OutlinedTextField(
        value = genderState.value,
        onValueChange = { genderState.value=it },
        modifier= Modifier
            .padding(start = 22.dp, end = 22.dp)
            .fillMaxWidth(),
        label = {Text(text = labelId) },
        enabled = enabled, singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction, textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            cursorColor = colorResource(id = R.color.Brown),
            // textColor = colorResource(id = R.color.Brown),
            // leadingIconColor = colorResource(id = R.color.Brown),
            //trailingIconColor = colorResource(id = R.color.Brown),
            errorCursorColor = colorResource(id = R.color.Brown),
            errorLeadingIconColor = colorResource(id = R.color.Brown),
            errorTrailingIconColor = colorResource(id = R.color.Brown),
            errorTextColor = colorResource(id = R.color.Brown),
            errorBorderColor = colorResource(id = R.color.Brown),
        ),
        //
        //BorderStroke(width = 5.dp, color = Color.Black)
    )

}