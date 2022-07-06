package xyz.ibudai.service;

import java.util.concurrent.Future;

public interface TestService {

    Future<String> myTask();

    Future<String> myTask1();
}
