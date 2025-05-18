package com.example.proyecto.service;

import org.springframework.stereotype.Service;

import com.example.proyecto.models.Seguro;
import com.example.proyecto.models.Vehiculo.TipoVehiculo;
import com.example.proyecto.models.Seguro.TipoSeguro;
import com.example.proyecto.repository.SeguroRepository;

@Service
public class SeguroService {

    private final SeguroRepository seguroRepository;

    public SeguroService(SeguroRepository seguroRepository) {
        this.seguroRepository = seguroRepository;
    }

    public Seguro crearSeguroPorTipoVehiculo(TipoVehiculo tipoVehiculo) {
        TipoSeguro tipoSeguro = switch (tipoVehiculo) {
            case COCHE -> TipoSeguro.COCHE;
            case BICI -> TipoSeguro.BICI;
            case SCOOTER -> TipoSeguro.SCOOTER;
        };

        Seguro seguro = new Seguro();
        seguro.setTipo(tipoSeguro);
        return seguroRepository.save(seguro);
    }
}

	


