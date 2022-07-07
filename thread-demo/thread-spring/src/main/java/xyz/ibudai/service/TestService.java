package xyz.ibudai.service;

import java.util.concurrent.Future;

public interface TestService {

    Future<String> Task();

    Future<String> Task1();

    Future<String> Task3();

    Future<String> Task4();
}
