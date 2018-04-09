package com.restesting.restesting.flowManager.validationRules.ChainDefinition;


import com.restesting.restesting.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ChainRespObject<T> {


    protected ChainRespObject<T> next;




    public void setNext(ChainRespObject<T> next) {
        this.next = next;
    }



    public T handle(T input) throws Exception {
        T t = handleWork(input);
        if(next!=null){
            next.handle(t);
        }
        return t;

    }


    abstract protected T handleWork(T input) throws Exception;
}
