package com.example.michaelsanchez.testapp.util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * We want this to be done at runtime.
 */

//Only initialize this class at runtime
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerController {

}
