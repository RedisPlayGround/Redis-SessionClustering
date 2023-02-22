package me.saechimdaeki.redissession

import jakarta.servlet.http.HttpSession
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {

    @GetMapping("/login")
    fun login(session : HttpSession, @RequestParam name : String) : String {
        session.setAttribute("name", name)
        return "saved"
    }

    @GetMapping("/myname")
    fun myName(@SessionLogin name: String?) : String {
        return name ?: "로그인 하세여"
    }
}