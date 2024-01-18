package org.boot;

import org.boot.spi.SpiApi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<SpiApi> serviceLoader = ServiceLoader.load(SpiApi.class);
        for (SpiApi spiApi : serviceLoader) {
            System.out.println(spiApi.getClass());;
        }
    }
}