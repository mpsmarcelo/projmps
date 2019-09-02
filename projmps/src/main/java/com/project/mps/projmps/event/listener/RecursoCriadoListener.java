package com.project.mps.projmps.event.listener;

import com.project.mps.projmps.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

/**
 * Created by Marcelo on 02/09/2019.
 */
@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {

       HttpServletResponse response = recursoCriadoEvent.getResponse();
       Long codigo = recursoCriadoEvent.getCodigo();


        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/codigo").buildAndExpand(codigo).toUri();
        response.setHeader("Location", uri.toASCIIString());

    }
}
