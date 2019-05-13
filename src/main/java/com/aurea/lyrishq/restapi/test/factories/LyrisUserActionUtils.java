package com.aurea.lyrishq.restapi.test.factories;

import com.xo.restapi.automation.context.UserData;
import com.xo.restapi.automation.types.Action;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.var;

@UtilityClass
public class LyrisUserActionUtils{

    public static boolean perform(UserData userdata, Action... actions) {
        var count = userdata.entrySet().stream().count();
        return perform(userdata.entrySet().stream().skip(count - 1).findFirst().get().getKey(), actions);
    }

    @SneakyThrows
    public static boolean perform(String username, Action... actions) {
        if (null == actions || actions.length == 0) {
            return false;
        }

        LyrisUserContext.setContext(username);

        Stream.of(actions)
                .forEach(Action::invoke);
        return true;
    }
}
