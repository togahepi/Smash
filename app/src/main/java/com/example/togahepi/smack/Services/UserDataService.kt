package com.example.togahepi.smack.Services

import android.graphics.Color
import java.util.*

/**
 * Created by jonnyb on 9/4/17.
 */
object UserDataService {

    var id = ""
    var avatarColor = ""
    var avatarName = ""
    var email = ""
    var name = ""

    fun logout() {
        id = ""
        avatarColor = ""
        avatarName = ""
        name = ""
        AuthService.authToken = ""
        AuthService.userEmail = ""
        AuthService.isLoggedIn = false
    }

    fun returnAvatarColor(components: String) : Int {
        //[0.5058823529411764, 0.6235294117647059, 0.1411764705882353, 1]
        //0.5058823529411764 0.6235294117647059 0.1411764705882353 1

        val strippedColor = components
            .replace("[", "")
            .replace("]", "")
            .replace(",", "")

        var r = 0
        var g = 0
        var b = 0

        val scanner = Scanner(strippedColor)

        if (scanner.hasNext()) {
            r = (scanner.nextDouble()*255).toInt()
            g = (scanner.nextDouble()*255).toInt()
            b = (scanner.nextDouble()*255).toInt()
        }
        return Color.rgb(r,g,b)
    }

}