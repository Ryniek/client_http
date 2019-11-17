package pl.rynski.lab_4_rynski.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rynski.lab_4_rynski.model.City;

@Controller
public class HomeController {

    private WeatherService weatherService;

    @Autowired
    public HomeController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("city", new City());
        return "index";
    }

    @PostMapping("/weather")
    public String getWeather(@ModelAttribute City city, Model model) {
        model.addAttribute("weather", weatherService.getCurrentWeather(city.getCityName()));
        return "weather";
    }

}
