package com.example.lastgradutionproject.screans.ClientScreans.Edit

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.Login.Email
import com.example.lastgradutionproject.screans.ClientScreans.Login.PasswordVisability
import com.example.lastgradutionproject.screans.ClientScreans.Login.passwordFailed
object Gender{
    const val male="Male"
    const val Famale="Famale"
}

@Composable
fun Edit(navController: NavController,
         loading:Boolean=false,
         isCreatAcount:Boolean=false,
         onDone:(String,String,String) -> Unit = {nn,cc,poh -> }
){
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val context = LocalContext.current
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)

    }
    val lancher= rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()){ uri: Uri? ->
        imageUri=uri
    }


    val selectGender = remember {
        mutableStateOf("")
    }

    val name= rememberSaveable {
        mutableStateOf("")

    }
    val country= rememberSaveable {
        mutableStateOf("")

    }
    val phone= rememberSaveable {
        mutableStateOf("")

    }

    val keyboardController= LocalSoftwareKeyboardController.current
    val valid= remember (name.value,country.value,phone.value){
        name.value.trim().isNotEmpty()&&  country.value.trim().isNotEmpty()&&  phone.value.trim().isNotEmpty()

    }



    Surface(color = Color.White) {


        Row {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Arrow back",
                tint = Color.Black,
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 15.dp, top = 8.dp)
                    .clickable {
                        navController.navigate(MillanoScreans.profilescrean.name)
                    }


            )
            Spacer(modifier =Modifier.  width(95.dp))

            Text(
                text = "Edit Profile",
                fontWeight = FontWeight.SemiBold,
                fontSize = 19.sp,
                modifier = Modifier
                    .padding(top = 65.dp)
                    .clickable {
                        //navController.navigate(MillanoScreans.editprofile.name)
                    },
                color = Color.Black
            )


        }
        Column (modifier = Modifier.padding(top = 100.dp, start = 160.dp)){
            Surface(
                modifier = Modifier
                    //.padding(top = 21.dp, start = 15.dp)

                    //.align(alignment = Alignment.CenterHorizontally)
                    .size(70.dp),

                shape = CircleShape
            ) {
                Image(
                    modifier = Modifier.size(80.dp),
                    painter = painterResource(id = R.drawable.img_5),
                    contentDescription = ""
                )


            }
            imageUri?.let {
                if (Build.VERSION.SDK_INT < 28){
                    bitmap.value= MediaStore.Images
                        .Media.getBitmap(context.contentResolver,it)
                }else{
                    val source = ImageDecoder.createSource(context.contentResolver,it)
                    bitmap.value= ImageDecoder.decodeBitmap(source)
                }
                bitmap.value?.let {btn ->
                    Image(
                        bitmap=btn.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .size(410.dp)
                            .padding(20.dp)
                    )

                }

            }
            Spacer(modifier = Modifier.height(12.dp))


            Text(text = "Edit photo", fontWeight = FontWeight.Bold, fontSize = 16.sp
                , modifier = Modifier
                   // .padding(top = 38.dp)
                    .clickable {
                               lancher.launch("*image/*")


                    }, color = Color.Black
            )
            Card (modifier = Modifier
                .width(81.dp)
                .height(3.dp),
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.black))


            ){

            }




        }
       // Spacer(modifier = Modifier.height(90.dp))
        Column (
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 270.dp)
        ) {

            myName(
                modifier = Modifier,
                navController = navController ,
                nameState = name,
                // passwordVisibility = passwordVisability,
                labelId = "Enter Your Name",
                enabled = !loading,
                onAction = KeyboardActions{
                    // passwordVisability=passwordVisability
                    if (!valid) return@KeyboardActions
                    onDone(name.value.trim(),  country.value.trim(),phone.value.trim()) })
            Spacer(modifier = Modifier.height(10.dp))
            myCountry(
                modifier = Modifier,
                navController = navController ,
                countrystate = country,
                // passwordVisibility = passwordVisability,
                labelId = "Enter Your Country",
                enabled = !loading,
                onAction = KeyboardActions{
                    // passwordVisability=passwordVisability
                    if (!valid) return@KeyboardActions
                    onDone(name.value.trim(),  country.value.trim(),phone.value.trim()) })
            Spacer(modifier = Modifier.height(10.dp))

            myPhone(
                modifier = Modifier,
                navController = navController ,
                phonestate = phone,
                // passwordVisibility = passwordVisability,
                labelId = "Phone Number",
                enabled = !loading,
                onAction = KeyboardActions{
                    // passwordVisability=passwordVisability
                    if (!valid) return@KeyboardActions
                    onDone(name.value.trim(),  country.value.trim(),phone.value.trim()) })
            Spacer(modifier = Modifier.height(10.dp))
            Column (modifier = Modifier.padding(start = 10.dp, end = 90.dp)){
                Text(text = "Gender", fontWeight = FontWeight.Bold, fontSize = 19.sp
                    , modifier = Modifier,
                        // .padding(top = 38.dp)
                    color = Color.Black)
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    RadioButton(selected = selectGender.value==Gender.male, onClick = {
                        selectGender.value=Gender.male
                    },
                        colors = RadioButtonDefaults.colors(Color.Green))
                    Spacer(modifier = Modifier.size(16.dp))

                    Text(text = "Male", fontWeight = FontWeight.Bold, fontSize = 17.sp
                        , modifier = Modifier.padding(top = 14.dp),
                        // .padding(top = 38.dp)
                        color = Color.Black)
                    Spacer(modifier = Modifier.size(16.dp))
                    RadioButton(selected = selectGender.value==Gender.Famale, onClick = {
                        selectGender.value=Gender.Famale
                    },
                        colors = RadioButtonDefaults.colors(Color.Green))
                    Spacer(modifier = Modifier.size(16.dp))

                    Text(text = "Famale", fontWeight = FontWeight.Bold, fontSize = 17.sp
                        , modifier = Modifier.padding(top = 14.dp),
                        // .padding(top = 38.dp)
                        color = Color.Black)





                }
                Spacer(modifier = Modifier.height(40.dp))
                Save(
                    //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                    loading = loading,
                    //validInputs = valid
                ) {
                    // onDone(Email.value.trim(), password.value.trim())
                    // navController.navigate(MillanoScreans.HomeScrean.name)

                }

            }

        }

    }
}


@Composable
fun myname(navController: NavController,
             modifier:Modifier=Modifier,
             nameState: MutableState<String>,
             labelId:String="Enter Your Name",
             enabled:Boolean=true,
             imeAction: ImeAction = ImeAction.Next,
             onAction: KeyboardActions = KeyboardActions.Default,
){
    /* passwordFailed( navController =navController,
         modifier =Modifier,
         passwordState = passwordState,
         labelId =labelId,
         enabled =enabled
         , imeAction =imeAction,
         keyboardType = KeyboardType.Password,
         passwordVisibility = ,
         onAction =onAction)*/

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myName(
    navController: NavController,
    modifier:Modifier=Modifier,
    nameState: MutableState<String>,
   // passwordVisibility: MutableState<Boolean>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = nameState.value,
        onValueChange = { nameState.value=it },
        modifier= Modifier
            .padding(start = 18.dp, end = 18.dp)
            .fillMaxWidth(),
        label = {Text(text = labelId) },
        enabled = enabled, singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction, textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            //focusedBorderColor = Color.Transparent,
            // unfocusedBorderColor = Color.Transparent,
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
@Composable
fun mycountry(navController: NavController,
             modifier:Modifier=Modifier,
             countrystate: MutableState<String>,
             labelId:String="Enter Your Country",
             enabled:Boolean=true,
             imeAction: ImeAction = ImeAction.Next,
             onAction: KeyboardActions = KeyboardActions.Default,
){
    /* passwordFailed( navController =navController,
         modifier =Modifier,
         passwordState = passwordState,
         labelId =labelId,
         enabled =enabled
         , imeAction =imeAction,
         keyboardType = KeyboardType.Password,
         passwordVisibility = ,
         onAction =onAction)*/

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myCountry(
    navController: NavController,
    modifier:Modifier=Modifier,
    countrystate: MutableState<String>,
    // passwordVisibility: MutableState<Boolean>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = countrystate.value,
        onValueChange = { countrystate.value=it },
        modifier= Modifier
            .padding(start = 18.dp, end = 18.dp)
            .fillMaxWidth(),
        label = {Text(text = labelId) },
        enabled = enabled, singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction, textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            //focusedBorderColor = Color.Transparent,
            // unfocusedBorderColor = Color.Transparent,
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

@Composable
fun myphone(navController: NavController,
             modifier:Modifier=Modifier,
             phonestate: MutableState<String>,
             labelId:String="Phone Number",
             enabled:Boolean=true,
             imeAction: ImeAction = ImeAction.Next,
             onAction: KeyboardActions = KeyboardActions.Default,
){
    /* passwordFailed( navController =navController,
         modifier =Modifier,
         passwordState = passwordState,
         labelId =labelId,
         enabled =enabled
         , imeAction =imeAction,
         keyboardType = KeyboardType.Password,
         passwordVisibility = ,
         onAction =onAction)*/

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myPhone(
    navController: NavController,
    modifier:Modifier=Modifier,
    phonestate: MutableState<String>,
    // passwordVisibility: MutableState<Boolean>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = phonestate.value,
        onValueChange = { phonestate.value=it },
        modifier= Modifier
            .padding(start = 18.dp, end = 18.dp)
            .fillMaxWidth(),
        label = {Text(text = labelId) },
        enabled = enabled, singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction, textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            //focusedBorderColor = Color.Transparent,
            // unfocusedBorderColor = Color.Transparent,
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
@Composable
fun Save(loading: Boolean,
    // validInputs: Boolean,
              onClick: () -> Unit) {
    Button(          onClick=onClick,
        modifier = Modifier
            .width(270.dp)
            .height(40.dp)
            .padding(start = 65.dp, end = 20.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        //enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "Save", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
        if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}




