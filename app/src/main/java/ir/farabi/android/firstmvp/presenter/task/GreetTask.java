package ir.farabi.android.firstmvp.presenter.task;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import ir.farabi.android.firstmvp.model.Constants;
import ir.farabi.android.firstmvp.model.Greeting;

/**
 * Created by amin on 12/10/17.
 */

public class GreetTask extends Task<List<Greeting>, Void> {

    @Override
    public List<Greeting> onTask(Void object) {
        String url = Constants.ENDPOINT + "/greeting";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        final Greeting greeting = restTemplate.getForObject(url, Greeting.class);
        ArrayList list = new ArrayList<Greeting>();
        list.add(greeting);
        return list;
    }
}
