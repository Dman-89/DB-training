package fialka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/test"])
class Controller {

    @Autowired
    private lateinit var service: Service

    @GetMapping("/ping")
    fun ping(): String? {
        return "blabla"
    }

    @PostMapping("/ping2")
    fun ping2() {
        service.save()
    }
}