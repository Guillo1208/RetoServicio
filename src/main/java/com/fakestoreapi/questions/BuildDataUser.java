package com.fakestoreapi.questions;

import com.fakestoreapi.models.Address;
import com.fakestoreapi.models.Geolocation;
import com.fakestoreapi.models.Name;
import com.fakestoreapi.models.UserModel;
import com.fakestoreapi.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildDataUser implements Question<UserModel> {
    @Override
    public UserModel answeredBy(Actor actor) {
        Map<String, String> data = Data.extractTo().get(0);
        List <Geolocation> geolocations = new ArrayList<>();
        List <Name> names = new ArrayList<>();
        List <Address> addresses = new ArrayList<>();

        Geolocation geolocation = Geolocation.builder()
                .lat("20°")
                ._long("15'")
                .build();
        geolocations.add(geolocation);

        Address address = Address.builder()
                .city("Monteria")
                .street("calle")
                .number(12)
                .zipcode("+57")
                .geolocation(geolocations)
                .build();

        Name name = Name.builder()
                .firstname(data.get("Primer Nombre"))
                .lastname(data.get("Segundo Nombre"))
                .build();
        names.add(name);

        UserModel userModel = UserModel.builder()
                .email(data.get("Correo"))
                .username(data.get("Usuario"))
                .password(data.get("Clave"))
                .name(names)
                .address(addresses)
                .phone("3156554023")
                .build();
        return userModel;
    }

    public static BuildDataUser was(){
        return new BuildDataUser();
    }

}
