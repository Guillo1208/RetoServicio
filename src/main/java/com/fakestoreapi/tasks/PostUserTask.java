package com.fakestoreapi.tasks;

import com.fakestoreapi.models.UserModel;
import com.fakestoreapi.models.responseDelet.DeletUserModel;
import com.fakestoreapi.questions.BuildDataUser;
import com.fakestoreapi.questions.PostResponse;
import com.fakestoreapi.questions.PutDataResponse;
import com.fakestoreapi.questions.ServerResponse;
import com.fakestoreapi.utils.Data;
import com.fakestoreapi.utils.EscribirEnExcel;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = Data.extractTo().get(0);
        UserModel userInf = actor.asksFor(BuildDataUser.was());
        actor.attemptsTo(
                Post.to(data.get("Endpoint")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInf)
                )

        );

        Integer IdRes = PostResponse.was().answeredBy(actor).getId();
        actor.attemptsTo(
                EscribirEnExcel.on("src\\main\\resources\\Data\\Data.xlsx","DatosUsuario",1,7, String.valueOf(IdRes))

        );

    }
    public static PostUserTask on(){
        return instrumented(PostUserTask.class);
    }

}
