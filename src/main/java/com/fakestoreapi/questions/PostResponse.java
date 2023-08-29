package com.fakestoreapi.questions;

import com.fakestoreapi.models.ResponsePost.ModelReponsePost;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PostResponse implements Question <ModelReponsePost> {
    @Override
    public ModelReponsePost answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ModelReponsePost.class);
    }
    public static PostResponse was(){
        return  new PostResponse();
    }
}
