package com.example.lastgradutionproject.screans.ClientScreans.OrderScrean

import android.util.Range
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.RoundedIcons
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.startScrean.nameFailed

@Composable
fun Order(navController: NavController,
          loading:Boolean=false,
          isCreatAcount:Boolean=false,
){
    val Range= IntRange(start = 1, endInclusive = 100)
    val totalPerPersonState = remember {
        mutableStateOf(0.0)
    }

    val splitByState= remember {
        mutableStateOf(1)
    }
    val feadbak = rememberSaveable {
        mutableStateOf("")

    }
    val passwordFocusRequest= FocusRequester.Default
    val keyboardController= LocalSoftwareKeyboardController.current

    Column (verticalArrangement = Arrangement.Top){
        Card (modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .height(190.dp),
            shape = RoundedCornerShape(corner = CornerSize(7.dp)),
            colors = CardDefaults.cardColors(colorResource(id = R.color.white))
        ) {
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Product Name: ", fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 5.dp),
            //color = Color.Black
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "$120 ", fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 5.dp),
            //color = Color.Black
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Product Code: aass213 ", fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 5.dp),
            //color = Color.Black
        )
        Spacer(modifier = Modifier.height(40.dp))

        Feadback(
            navController = navController,
            feadbakState = feadbak,
            enabled = !loading,
            onAction = KeyboardActions {
                passwordFocusRequest.requestFocus()
            })
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Text(text = "Color ", fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 5.dp),
                fontSize = 22.sp,
                //color = Color.Black
            )

        }
        Spacer(modifier = Modifier.height(30.dp))

        Row {
            Text(text = "Size ", fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 5.dp),
                fontSize = 22.sp,

                //color = Color.Black
            )
            Spacer(modifier = Modifier.width(130.dp))
            Card (modifier = Modifier
                .width(35.dp)
                .height(35.dp),
               // shape = RectangleShape,
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))


            ){
                Text(text = "xs ", fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                    color = Color.Black,
                    fontSize = 18.sp,

                    )

            }
            Spacer(modifier = Modifier.width(12.dp))

            Card (modifier = Modifier
                .width(35.dp)
                .height(35.dp),
                // shape = RectangleShape,
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))


            ){
                Text(text = "S ", fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                    color = Color.Black,
                    fontSize = 22.sp,

                    )

            }
            Spacer(modifier = Modifier.width(12.dp))

            Card (modifier = Modifier
                .width(35.dp)
                .height(35.dp),
                // shape = RectangleShape,
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))


            ){
                Text(text = "M ", fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                    color = Color.Black,
                    fontSize = 22.sp,

                    )

            }
            Spacer(modifier = Modifier.width(12.dp))

            Card (modifier = Modifier
                .width(35.dp)
                .height(35.dp),
                // shape = RectangleShape,
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))


            ){
                Text(text = "L ", fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                    color = Color.Black,
                    fontSize = 22.sp,

                    )

            }



        }
        Spacer(modifier = Modifier.height(30.dp))
Row {
    Text(text = "Quantaty ", fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 5.dp),
        //color = Color.Black
        fontSize = 22.sp,

        )
    Spacer(modifier = Modifier.width(160.dp))
   // Image(imageVector =, contentDescription = )
    RoundedIcons(modifier = Modifier, imageVector = Icons.Default.Add,
        onClick = {
            splitByState.value=
                if (splitByState.value>1) splitByState.value -1

                else 1

           /* totalPerPersonState.value=
                calculateTotalPerperson(titleBill = totalBillState.value.toDouble(), splitBy = splitByState.value,
                    tipPersentage=tipPersentage)*/


        })
    Text(
        text = "${splitByState.value}",
        modifier = Modifier
            .align(alignment = Alignment.CenterVertically)
            .padding(start = 4.dp, top = 9.dp),
        fontSize = 22.sp
    )
    RoundedIcons(modifier = Modifier, imageVector = Icons.Default.Add,
        onClick = {
            if (splitByState.value< Range.last)
                splitByState.value=splitByState.value+1

           /* totalPerPersonState.value=
                calculateTotalPerperson(titleBill = totalBillState.value.toDouble(), splitBy = splitByState.value,
                    tipPersentage=tipPersentage)*/




        })


}
        Spacer(modifier = Modifier.height(60.dp))

        AddtoCardButton(
            //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
            loading = loading,
            //validInputs = valid
        ) {
           // onDone(Name.value.trim(), Country.value.trim(), Gender.value.trim())
            navController.navigate(MillanoScreans.prossingscrean.name)

        }

    }

   // RoundedIcons(modifier = Modifier, imageVector = Icons.Default.Remove , onClick = { /*TODO*/ })
   // RoundedIcons(modifier = Modifier, imageVector = Icons.Default.Add, onClick = { /*TODO*/ })
}
@Composable
fun AddtoCardButton(
    //textId: Unit ,
    loading: Boolean,
    //validInputs: Boolean,
    onClick: () -> Unit) {
    Button(          onClick=onClick,
        modifier = Modifier
            .width(350.dp)
            .height(45.dp)
            .padding(start = 48.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
       // enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "Add to Card", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
        if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
        // else Text(text = textId, modifier = Modifier.padding(5.dp))
    }

}







@Composable
fun Feadback(navController: NavController,
         modifier:Modifier=Modifier,
             feadbakState: MutableState<String>,
         labelId:String="Add Feadback",
         enabled:Boolean=true,
         imeAction: ImeAction = ImeAction.Next,
         onAction: KeyboardActions = KeyboardActions.Default,
){
    nameFailed( navController=navController,
        modifier=Modifier,
        feadbakState=feadbakState
        ,labelId=labelId,
        enabled=enabled
        ,imeAction=imeAction,
        keyboardType= KeyboardType.Text,
        onAction=onAction)

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun nameFailed(
    navController: NavController,
    modifier:Modifier=Modifier,
    feadbakState:MutableState<String>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType=KeyboardType.Text,
    imeAction:ImeAction= ImeAction.Next,
    onAction:KeyboardActions=KeyboardActions.Default,
) {
    OutlinedTextField(
        value = feadbakState.value,
        onValueChange = { feadbakState.value =it},
        modifier= Modifier
            .padding(start = 10.dp, end = 10.dp)
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
