package test.platzi.com.raian.com.org.simpleplatzi.constants

class GlobalConstants{
    companion object {
        const val baseURL : String = "https://api.github.com"

        //10.0.2.2 for Running in the emulator
        const val baseURLAuthorization : String = "http://10.0.2.2:3000"

        const val walmartAPIKey : String = "p9snnve8t8u7u857scdzrbdw"

        //http://api.walmartlabs.com/v1/search?apiKey=p9snnve8t8u7u857scdzrbdw&query=chips
        const val baseURLWalmart : String = "http://api.walmartlabs.com/v1"

    }
}