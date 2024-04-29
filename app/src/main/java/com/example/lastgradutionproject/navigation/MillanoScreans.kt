package com.example.lastgradutionproject.navigation

import com.example.lastgradutionproject.screans.startScrean.StartScrean

enum class MillanoScreans {
        //ClientScreans
        SplashScrean,
        OnBordingScrean,
        StartScrean,
        LoginScrean,
        SignUpScrean,
        HomeScrean,
        SearchScrean,
        WomenScrean,
        MenScrean,
        KidsScrean,
        OrderScrean,
        ShosesScrean,
        Historyscrean,
    prossingscrean,
    shipingscrean,
    favouritescrean,
    profilescrean,
    editprofile,
    reportscrean,

        //DesignerScreans
        DesignerHomeScrean,
        myDesignsScreans,
        HistoryScrean,

        //commonScreans
        ProfileScrean,
        EditProfileScrean,
        ChangePasswordScrean,
        ChangeEmailScrean,
        ChangePhoneScrean,
        ChangeAddressScrean,
        ChangeLanguageScrean,
        ChangeCurrencyScrean,
        ChangeNotificationScrean,
        ChangePrivacyScrean,
        ChangeTermsScrean,
        ChangeAboutScrean,
        ChangeContactUsScrean,
        ChangeFAQScrean,
        ChangeHowToUseScrean,
        ChangeHowToRegisterScrean,
        ChangeHowToLoginScrean,
        ChangeHowToBookScrean,
        ChangeHowToReserveScrean,
        ChangeHowToCancelScrean,
        ChangeHowToPayScrean,
        ChangeHowToRateScrean,
        ChangeHowToEditProfileScrean,
        ChangeHowToChangePasswordScrean,
        ChangeHowToChangeEmailScrean,
        ChangeHowToChangePhoneScrean,
        ChangeHowToChangeAddressScrean,
        ChangeHowToChangeLanguageScrean,
        ChangeHowToChangeCurrencyScrean,
        ChangeHowToChangeNotificationScrean,
        ChangeHowToChangePrivacyScrean,
        ChangeHowToChangeTermsScrean,
        ChangeHowToChangeAboutScrean,
        ChangeHowToChangeContactUsScrean,
        ChangeHowToChangeFAQScrean,
        ChangeHowToChangeHowToUseScrean,
        ChangeHowToChangeHowToRegisterScrean,
        ChangeHowToChangeHowToLoginScrean,
        ChangeHowToChangeHowToBookScrean,
        ChangeHowToChangeHowToReserveScrean,
        ChangeHowToChangeHowToCancelScrean,
        ChangeHowToChangeHowToPayScrean,
        ChangeHowToChangeHowToRateScrean;


        companion object {
            fun getScreenName(screen: MillanoScreans): String {
                return when (screen) {
                    SplashScrean -> SplashScrean.name
                    OnBordingScrean -> OnBordingScrean.name
                    StartScrean -> StartScrean.name
                    OrderScrean -> OrderScrean.name
                        WomenScrean -> WomenScrean.name
                    LoginScrean -> LoginScrean.name
                        MenScrean -> MenScrean.name
                        KidsScrean -> KidsScrean.name
                        ShosesScrean-> ShosesScrean.name
                    SignUpScrean -> SignUpScrean.name
                    Historyscrean -> Historyscrean.name
                    prossingscrean -> prossingscrean.name
                    shipingscrean -> shipingscrean.name
                    HomeScrean -> HomeScrean.name
                    profilescrean -> profilescrean.name
                    editprofile -> editprofile.name
                    reportscrean -> reportscrean.name
                    favouritescrean -> favouritescrean.name
                    SearchScrean -> SearchScrean.name
                    null -> "null"


                    else -> throw IllegalArgumentException("Screan not found")
                }
            }
        }
    }


