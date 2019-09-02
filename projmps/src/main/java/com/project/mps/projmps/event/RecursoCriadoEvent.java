package com.project.mps.projmps.event;

import com.sun.deploy.net.HttpResponse;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Marcelo on 02/09/2019.
 */
public class RecursoCriadoEvent extends ApplicationEvent{


    private HttpServletResponse response;
    private Long codigo;

    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response = response;
        this.codigo = codigo;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

}
