package pl.rynski.lab_4_rynski.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.rynski.lab_4_rynski.model.WeatherModel;

@Service
public class WeatherService {

    public WeatherModel getCurrentWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        WeatherModel weather = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?appid=a483589fe61f6979b32cc17456883b21&q=" + city,
                WeatherModel.class);
        weather.setIconUrl("http://openweathermap.org/img/wn/" + weather.getWeather().get(0).getIcon() + ".png");
        return weather;
    }

}
