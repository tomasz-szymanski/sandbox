package com.tutorial.lambda;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

    private  List<Integer> integers;

    @Before
    public void setUp() throws Exception {
        integers = Arrays.asList(2, 3, 4);
    }

    @Test
    public void shouldCreateLambdaSimpleLambda() {
        List<Integer> integers = Arrays.asList(2, 3, 4);
        List<Integer> collect = integers.stream().map(el -> el * 2).collect(Collectors.toList());

        System.out.println(collect);
        Assert.assertEquals("[4, 6, 8]", collect.toString());
    }


    @Test
    public void shouldCreateLambdaSimpleWay() {
        List<Integer> integers = Arrays.asList(2, 3, 4);
        integers.forEach(el -> System.out.println(el.hashCode()));
    }

    @Test
    public void shouldCreateLambdaAsMethodReference() {
        List<Integer> integers = Arrays.asList(2, 3, 4);
        integers.forEach(System.out::println);
    }

    @Test
    public void shouldFilterUsingLambda() {
        List<Integer> filtered = integers.stream().filter(integer -> integer > 2).collect(Collectors.toList());
        Assert.assertEquals("[3, 4]", filtered.toString());
    }

    @Test
    public void shouldMapUsingFunctionalInterfaceAndMethodReference() {
        DoubleToIntFunction func = value -> 2;

        Assert.assertEquals("[2, 2, 2, 2]",
                Stream.of(2d, 3d, 4d, 5d).map(func::applyAsInt).collect(Collectors.toList()).toString()
        );
    }

    @Test
    public void shouldMapUsingFunctionalInterfaceAndLambda() {
        DoubleToIntFunction func = value -> 2;

        Assert.assertEquals("[2, 2, 2, 2]",
                Stream.of(2d, 3d, 4d, 5d).map(el -> func.applyAsInt(el)).collect(Collectors.toList()).toString()
        );
    }

    @Test
    public void shouldFilterUsingLambda1() {
        Assert.assertEquals("[5]",
                Stream.of(2, 3, 4, 5).filter(el -> el > 4).collect(Collectors.toList()).toString()
        );
    }


}
