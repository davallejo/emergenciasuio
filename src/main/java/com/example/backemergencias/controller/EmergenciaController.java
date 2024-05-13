package com.example.backemergencias.controller;

import com.example.backemergencias.entity.Emergencia;
import com.example.backemergencias.service.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emergencias")
public class EmergenciaController {

    @Autowired
    private EmergenciaService emergenciaService;

    private static final String WEATHER_API_KEY = "200bb23de83dec3aacea1512b4c1f7a4";
    private static final String WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather";

    @GetMapping
    public List<Emergencia> getAllEmergencias() {
        return emergenciaService.getAllEmergencias();
    }

    @PostMapping
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia) {
        // Obtener temperatura desde la API de OpenWeatherMap
        double temperatura = obtenerTemperaturaDesdeAPI(emergencia.getUbicacion());
        emergencia.setTemperatura(temperatura);

        return emergenciaService.createEmergencia(emergencia);
    }

    @GetMapping("/{id}")
    public Optional<Emergencia> getEmergenciaById(@PathVariable Integer id) {
        return emergenciaService.getEmergenciaById(id);
    }

    @PutMapping("/{id}")
    public Emergencia updateEmergencia(@PathVariable Integer id, @RequestBody Emergencia emergencia) {
        return emergenciaService.updateEmergencia(id, emergencia);
    }

    @DeleteMapping("/{id}")
    public void deleteEmergencia(@PathVariable Integer id) {
        emergenciaService.deleteEmergencia(id);
    }

    private double obtenerTemperaturaDesdeAPI(String ubicacion) {
        String[] coordenadas = ubicacion.split(",");
        String latitud = coordenadas[0];
        String longitud = coordenadas[1];

        String url = WEATHER_API_URL + "?lat=" + latitud + "&lon=" + longitud + "&appid=" + WEATHER_API_KEY + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeatherApiResponse> responseEntity = restTemplate.getForEntity(url, WeatherApiResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            WeatherApiResponse weatherApiResponse = responseEntity.getBody();
            if (weatherApiResponse != null) {
                return weatherApiResponse.getMain().getTemp();
            }
        }

        // Si no se puede obtener la temperatura, retorna un valor por defecto
        return 0.0;
    }


    private static class WeatherApiResponse {
        private MainData main;

        public MainData getMain() {
            return main;
        }

        public void setMain(MainData main) {
            this.main = main;
        }
    }

    private static class MainData {
        private double temp;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }
}
