package com.thoughtworks.tdd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Router {
    private final String initRoutePath;
    private String currentPath;
    private Map<String, BaseController> routeMaps = new HashMap<>();
    public Router(String initStatus) {
        this.initRoutePath = initStatus;
        this.currentPath = initStatus;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }


    public void processRequest(String str) {
        String routePath = buildLocateRoutePath(str);
        String forwardRouteRule = routeMaps.get(routePath).process();
        currentPath = routePath;
        if (forwardRouteRule != null && forwardRouteRule.contains("forward:")) {
            currentPath = buildForwardRoutePath(forwardRouteRule);
        }
    }

    private String buildForwardRoutePath(String forwardRouteRule) {
        String forwardRoute = forwardRouteRule.split(":")[1];
        routeMaps.get(forwardRoute).process();
        return forwardRoute;
    }

    private String buildLocateRoutePath(String str) {
        String subPath = str.isEmpty() ? "" : "/" + translateRequestInput(str);
        return currentPath + subPath;
    }

    private String translateRequestInput(String str) {
        if (Arrays.asList("1", "2").contains(str)) {
            return str;
        } else {
            return "*";
        }
    }

    public void registerRouter(String path, BaseController controller){
        routeMaps.put(path, controller);
    }
}
