package com.jolt.joltapi;

import org.springframework.stereotype.Service;
import com.bazaarvoice.jolt.Chainr;

@Service
public class JoltProcessor {
    public Object process(Object input, Object spec) {
//        List chainrSpecJSON = JsonUtils.jsonToList(spec);
        Chainr chainr = Chainr.fromSpec( spec );
//        Object inputJSON = JsonUtils.jsonToObject(input);
        return chainr.transform( input );
    }
}
