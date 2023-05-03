/*
 * Copyright (C) 2009 The JSR-330 Expert Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.atinject.tck.auto;

import junit.framework.TestCase;
import org.atinject.tck.auto.accessories.Cupholder;
import org.atinject.tck.auto.accessories.SpareTire;
import org.atinject.tck.auto.accessories.RoundThing;

import javax.inject.InjectDagger1;
import javax.inject.NamedDagger1;
import javax.inject.ProviderDagger1;

public class Convertible implements Car {

    @InjectDagger1
    @Drivers Seat driversSeatA;
    @InjectDagger1
    @Drivers Seat driversSeatB;
    @InjectDagger1
    SpareTire spareTire;
    @InjectDagger1
    Cupholder cupholder;
    @InjectDagger1
    ProviderDagger1<Engine> engineProviderDagger1;

    private boolean methodWithZeroParamsInjected;
    private boolean methodWithMultipleParamsInjected;
    private boolean methodWithNonVoidReturnInjected;

    private Seat constructorPlainSeat;
    private Seat constructorDriversSeat;
    private Tire constructorPlainTire;
    private Tire constructorSpareTire;
    private ProviderDagger1<Seat> constructorPlainSeatProviderDagger1 = nullProvider();
    private ProviderDagger1<Seat> constructorDriversSeatProviderDagger1 = nullProvider();
    private ProviderDagger1<Tire> constructorPlainTireProviderDagger1 = nullProvider();
    private ProviderDagger1<Tire> constructorSpareTireProviderDagger1 = nullProvider();

    @InjectDagger1
    Seat fieldPlainSeat;
    @InjectDagger1
    @Drivers Seat fieldDriversSeat;
    @InjectDagger1
    Tire fieldPlainTire;
    @InjectDagger1
    @NamedDagger1("spare") Tire fieldSpareTire;
    @InjectDagger1
    ProviderDagger1<Seat> fieldPlainSeatProviderDagger1 = nullProvider();
    @InjectDagger1
    @Drivers
    ProviderDagger1<Seat> fieldDriversSeatProviderDagger1 = nullProvider();
    @InjectDagger1
    ProviderDagger1<Tire> fieldPlainTireProviderDagger1 = nullProvider();
    @InjectDagger1
    @NamedDagger1("spare")
    ProviderDagger1<Tire> fieldSpareTireProviderDagger1 = nullProvider();

    private Seat methodPlainSeat;
    private Seat methodDriversSeat;
    private Tire methodPlainTire;
    private Tire methodSpareTire;
    private ProviderDagger1<Seat> methodPlainSeatProviderDagger1 = nullProvider();
    private ProviderDagger1<Seat> methodDriversSeatProviderDagger1 = nullProvider();
    private ProviderDagger1<Tire> methodPlainTireProviderDagger1 = nullProvider();
    private ProviderDagger1<Tire> methodSpareTireProviderDagger1 = nullProvider();

    @InjectDagger1
    static Seat staticFieldPlainSeat;
    @InjectDagger1
    @Drivers static Seat staticFieldDriversSeat;
    @InjectDagger1
    static Tire staticFieldPlainTire;
    @InjectDagger1
    @NamedDagger1("spare") static Tire staticFieldSpareTire;
    @InjectDagger1
    static ProviderDagger1<Seat> staticFieldPlainSeatProviderDagger1 = nullProvider();
    @InjectDagger1
    @Drivers static ProviderDagger1<Seat> staticFieldDriversSeatProviderDagger1 = nullProvider();
    @InjectDagger1
    static ProviderDagger1<Tire> staticFieldPlainTireProviderDagger1 = nullProvider();
    @InjectDagger1
    @NamedDagger1("spare") static ProviderDagger1<Tire> staticFieldSpareTireProviderDagger1 = nullProvider();

    private static Seat staticMethodPlainSeat;
    private static Seat staticMethodDriversSeat;
    private static Tire staticMethodPlainTire;
    private static Tire staticMethodSpareTire;
    private static ProviderDagger1<Seat> staticMethodPlainSeatProviderDagger1 = nullProvider();
    private static ProviderDagger1<Seat> staticMethodDriversSeatProviderDagger1 = nullProvider();
    private static ProviderDagger1<Tire> staticMethodPlainTireProviderDagger1 = nullProvider();
    private static ProviderDagger1<Tire> staticMethodSpareTireProviderDagger1 = nullProvider();

    @InjectDagger1
    Convertible(
            Seat plainSeat,
            @Drivers Seat driversSeat,
            Tire plainTire,
            @NamedDagger1("spare") Tire spareTire,
            ProviderDagger1<Seat> plainSeatProviderDagger1,
            @Drivers ProviderDagger1<Seat> driversSeatProviderDagger1,
            ProviderDagger1<Tire> plainTireProviderDagger1,
            @NamedDagger1("spare") ProviderDagger1<Tire> spareTireProviderDagger1) {
        constructorPlainSeat = plainSeat;
        constructorDriversSeat = driversSeat;
        constructorPlainTire = plainTire;
        constructorSpareTire = spareTire;
        constructorPlainSeatProviderDagger1 = plainSeatProviderDagger1;
        constructorDriversSeatProviderDagger1 = driversSeatProviderDagger1;
        constructorPlainTireProviderDagger1 = plainTireProviderDagger1;
        constructorSpareTireProviderDagger1 = spareTireProviderDagger1;
    }

    Convertible() {
        throw new AssertionError("Unexpected call to non-injectable constructor");
    }

    void setSeat(Seat unused) {
        throw new AssertionError("Unexpected call to non-injectable method");
    }

    @InjectDagger1
    void injectMethodWithZeroArgs() {
        methodWithZeroParamsInjected = true;
    }

    @InjectDagger1
    String injectMethodWithNonVoidReturn() {
        methodWithNonVoidReturnInjected = true;
        return "unused";
    }

    @InjectDagger1
    void injectInstanceMethodWithManyArgs(
            Seat plainSeat,
            @Drivers Seat driversSeat,
            Tire plainTire,
            @NamedDagger1("spare") Tire spareTire,
            ProviderDagger1<Seat> plainSeatProviderDagger1,
            @Drivers ProviderDagger1<Seat> driversSeatProviderDagger1,
            ProviderDagger1<Tire> plainTireProviderDagger1,
            @NamedDagger1("spare") ProviderDagger1<Tire> spareTireProviderDagger1) {
        methodWithMultipleParamsInjected = true;

        methodPlainSeat = plainSeat;
        methodDriversSeat = driversSeat;
        methodPlainTire = plainTire;
        methodSpareTire = spareTire;
        methodPlainSeatProviderDagger1 = plainSeatProviderDagger1;
        methodDriversSeatProviderDagger1 = driversSeatProviderDagger1;
        methodPlainTireProviderDagger1 = plainTireProviderDagger1;
        methodSpareTireProviderDagger1 = spareTireProviderDagger1;
    }

    @InjectDagger1
    static void injectStaticMethodWithManyArgs(
            Seat plainSeat,
            @Drivers Seat driversSeat,
            Tire plainTire,
            @NamedDagger1("spare") Tire spareTire,
            ProviderDagger1<Seat> plainSeatProviderDagger1,
            @Drivers ProviderDagger1<Seat> driversSeatProviderDagger1,
            ProviderDagger1<Tire> plainTireProviderDagger1,
            @NamedDagger1("spare") ProviderDagger1<Tire> spareTireProviderDagger1) {
        staticMethodPlainSeat = plainSeat;
        staticMethodDriversSeat = driversSeat;
        staticMethodPlainTire = plainTire;
        staticMethodSpareTire = spareTire;
        staticMethodPlainSeatProviderDagger1 = plainSeatProviderDagger1;
        staticMethodDriversSeatProviderDagger1 = driversSeatProviderDagger1;
        staticMethodPlainTireProviderDagger1 = plainTireProviderDagger1;
        staticMethodSpareTireProviderDagger1 = spareTireProviderDagger1;
    }

    /**
     * Returns a provider that always returns null. This is used as a default
     * value to avoid null checks for omitted provider injections.
     */
    private static <T> ProviderDagger1<T> nullProvider() {
        return new ProviderDagger1<T>() {
            public T get() {
                return null;
            }
        };
    }

    public static ThreadLocal<Convertible> localConvertible
            = new ThreadLocal<Convertible>();

    public static class Tests extends TestCase {

        private final Convertible car = localConvertible.get();
        private final Cupholder cupholder = car.cupholder;
        private final SpareTire spareTire = car.spareTire;
        private final Tire plainTire = car.fieldPlainTire;
        private final Engine engine = car.engineProviderDagger1.get();

        // smoke tests: if these fail all bets are off

        public void testFieldsInjected() {
            assertTrue(cupholder != null && spareTire != null);
        }

        public void testProviderReturnedValues() {
            assertTrue(engine != null);
        }

        // injecting different kinds of members

        public void testMethodWithZeroParametersInjected() {
            assertTrue(car.methodWithZeroParamsInjected);
        }

        public void testMethodWithMultipleParametersInjected() {
            assertTrue(car.methodWithMultipleParamsInjected);
        }

        public void testNonVoidMethodInjected() {
            assertTrue(car.methodWithNonVoidReturnInjected);
        }

        public void testPublicNoArgsConstructorInjected() {
            assertTrue(engine.publicNoArgsConstructorInjected);
        }

        public void testSubtypeFieldsInjected() {
            assertTrue(spareTire.hasSpareTireBeenFieldInjected());
        }

        public void testSubtypeMethodsInjected() {
            assertTrue(spareTire.hasSpareTireBeenMethodInjected());
        }

        public void testSupertypeFieldsInjected() {
            assertTrue(spareTire.hasTireBeenFieldInjected());
        }

        public void testSupertypeMethodsInjected() {
            assertTrue(spareTire.hasTireBeenMethodInjected());
        }

        public void testTwiceOverriddenMethodInjectedWhenMiddleLacksAnnotation() {
            assertTrue(engine.overriddenTwiceWithOmissionInMiddleInjected);
        }

        // injected values

        public void testQualifiersNotInheritedFromOverriddenMethod() {
            assertFalse(engine.qualifiersInheritedFromOverriddenMethod);
        }

        public void testConstructorInjectionWithValues() {
            assertFalse("Expected unqualified value",
                    car.constructorPlainSeat instanceof DriversSeat);
            assertFalse("Expected unqualified value",
                    car.constructorPlainTire instanceof SpareTire);
            assertTrue("Expected qualified value",
                    car.constructorDriversSeat instanceof DriversSeat);
            assertTrue("Expected qualified value",
                    car.constructorSpareTire instanceof SpareTire);
        }

        public void testFieldInjectionWithValues() {
            assertFalse("Expected unqualified value",
                    car.fieldPlainSeat instanceof DriversSeat);
            assertFalse("Expected unqualified value",
                    car.fieldPlainTire instanceof SpareTire);
            assertTrue("Expected qualified value",
                    car.fieldDriversSeat instanceof DriversSeat);
            assertTrue("Expected qualified value",
                    car.fieldSpareTire instanceof SpareTire);
        }

        public void testMethodInjectionWithValues() {
            assertFalse("Expected unqualified value",
                    car.methodPlainSeat instanceof DriversSeat);
            assertFalse("Expected unqualified value",
                    car.methodPlainTire instanceof SpareTire);
            assertTrue("Expected qualified value",
                    car.methodDriversSeat instanceof DriversSeat);
            assertTrue("Expected qualified value",
                    car.methodSpareTire instanceof SpareTire);
        }

        // injected providers

        public void testConstructorInjectionWithProviders() {
            assertFalse("Expected unqualified value",
                    car.constructorPlainSeatProviderDagger1.get() instanceof DriversSeat);
            assertFalse("Expected unqualified value",
                    car.constructorPlainTireProviderDagger1.get() instanceof SpareTire);
            assertTrue("Expected qualified value",
                    car.constructorDriversSeatProviderDagger1.get() instanceof DriversSeat);
            assertTrue("Expected qualified value",
                    car.constructorSpareTireProviderDagger1.get() instanceof SpareTire);
        }

        public void testFieldInjectionWithProviders() {
            assertFalse("Expected unqualified value",
                    car.fieldPlainSeatProviderDagger1.get() instanceof DriversSeat);
            assertFalse("Expected unqualified value",
                    car.fieldPlainTireProviderDagger1.get() instanceof SpareTire);
            assertTrue("Expected qualified value",
                    car.fieldDriversSeatProviderDagger1.get() instanceof DriversSeat);
            assertTrue("Expected qualified value",
                    car.fieldSpareTireProviderDagger1.get() instanceof SpareTire);
        }

        public void testMethodInjectionWithProviders() {
            assertFalse("Expected unqualified value",
                    car.methodPlainSeatProviderDagger1.get() instanceof DriversSeat);
            assertFalse("Expected unqualified value",
                    car.methodPlainTireProviderDagger1.get() instanceof SpareTire);
            assertTrue("Expected qualified value",
                    car.methodDriversSeatProviderDagger1.get() instanceof DriversSeat);
            assertTrue("Expected qualified value",
                    car.methodSpareTireProviderDagger1.get() instanceof SpareTire);
        }


        // singletons

        public void testConstructorInjectedProviderYieldsSingleton() {
            assertSame("Expected same value",
                    car.constructorPlainSeatProviderDagger1.get(), car.constructorPlainSeatProviderDagger1.get());
        }

        public void testFieldInjectedProviderYieldsSingleton() {
            assertSame("Expected same value",
                    car.fieldPlainSeatProviderDagger1.get(), car.fieldPlainSeatProviderDagger1.get());
        }

        public void testMethodInjectedProviderYieldsSingleton() {
            assertSame("Expected same value",
                    car.methodPlainSeatProviderDagger1.get(), car.methodPlainSeatProviderDagger1.get());
        }

        public void testCircularlyDependentSingletons() {
            // uses provider.get() to get around circular deps
            assertSame(cupholder.seatProviderDagger1.get().getCupholder(), cupholder);
        }


        // non singletons

        public void testSingletonAnnotationNotInheritedFromSupertype() {
            assertNotSame(car.driversSeatA, car.driversSeatB);
        }

        public void testConstructorInjectedProviderYieldsDistinctValues() {
            assertNotSame("Expected distinct values",
                    car.constructorDriversSeatProviderDagger1.get(), car.constructorDriversSeatProviderDagger1.get());
            assertNotSame("Expected distinct values",
                    car.constructorPlainTireProviderDagger1.get(), car.constructorPlainTireProviderDagger1.get());
            assertNotSame("Expected distinct values",
                    car.constructorSpareTireProviderDagger1.get(), car.constructorSpareTireProviderDagger1.get());
        }

        public void testFieldInjectedProviderYieldsDistinctValues() {
            assertNotSame("Expected distinct values",
                    car.fieldDriversSeatProviderDagger1.get(), car.fieldDriversSeatProviderDagger1.get());
            assertNotSame("Expected distinct values",
                    car.fieldPlainTireProviderDagger1.get(), car.fieldPlainTireProviderDagger1.get());
            assertNotSame("Expected distinct values",
                    car.fieldSpareTireProviderDagger1.get(), car.fieldSpareTireProviderDagger1.get());
        }

        public void testMethodInjectedProviderYieldsDistinctValues() {
            assertNotSame("Expected distinct values",
                    car.methodDriversSeatProviderDagger1.get(), car.methodDriversSeatProviderDagger1.get());
            assertNotSame("Expected distinct values",
                    car.methodPlainTireProviderDagger1.get(), car.methodPlainTireProviderDagger1.get());
            assertNotSame("Expected distinct values",
                    car.methodSpareTireProviderDagger1.get(), car.methodSpareTireProviderDagger1.get());
        }


        // mix inheritance + visibility

        public void testPackagePrivateMethodInjectedDifferentPackages() {
            assertTrue(spareTire.subPackagePrivateMethodInjected);
            assertTrue(spareTire.superPackagePrivateMethodInjected);
        }

        public void testOverriddenProtectedMethodInjection() {
            assertTrue(spareTire.subProtectedMethodInjected);
            assertFalse(spareTire.superProtectedMethodInjected);
        }

        public void testOverriddenPublicMethodNotInjected() {
            assertTrue(spareTire.subPublicMethodInjected);
            assertFalse(spareTire.superPublicMethodInjected);
        }


        // inject in order

        public void testFieldsInjectedBeforeMethods() {
            assertFalse(spareTire.methodInjectedBeforeFields);
        }

        public void testSupertypeMethodsInjectedBeforeSubtypeFields() {
            assertFalse(spareTire.subtypeFieldInjectedBeforeSupertypeMethods);
        }

        public void testSupertypeMethodInjectedBeforeSubtypeMethods() {
            assertFalse(spareTire.subtypeMethodInjectedBeforeSupertypeMethods);
        }


        // necessary injections occur

        public void testPackagePrivateMethodInjectedEvenWhenSimilarMethodLacksAnnotation() {
            assertTrue(spareTire.subPackagePrivateMethodForOverrideInjected);
        }


        // override or similar method without @Inject

        public void testPrivateMethodNotInjectedWhenSupertypeHasAnnotatedSimilarMethod() {
            assertFalse(spareTire.superPrivateMethodForOverrideInjected);
        }

        public void testPackagePrivateMethodNotInjectedWhenOverrideLacksAnnotation() {
            assertFalse(engine.subPackagePrivateMethodForOverrideInjected);
            assertFalse(engine.superPackagePrivateMethodForOverrideInjected);
        }

        public void testPackagePrivateMethodNotInjectedWhenSupertypeHasAnnotatedSimilarMethod() {
            assertFalse(spareTire.superPackagePrivateMethodForOverrideInjected);
        }

        public void testProtectedMethodNotInjectedWhenOverrideNotAnnotated() {
            assertFalse(spareTire.protectedMethodForOverrideInjected);
        }

        public void testPublicMethodNotInjectedWhenOverrideNotAnnotated() {
            assertFalse(spareTire.publicMethodForOverrideInjected);
        }

        public void testTwiceOverriddenMethodNotInjectedWhenOverrideLacksAnnotation() {
            assertFalse(engine.overriddenTwiceWithOmissionInSubclassInjected);
        }

        public void testOverriddingMixedWithPackagePrivate2() {
            assertTrue(spareTire.packagePrivateMethod2Injected);
            assertTrue(((Tire) spareTire).packagePrivateMethod2Injected);
            assertFalse(((RoundThing) spareTire).packagePrivateMethod2Injected);

            assertTrue(plainTire.packagePrivateMethod2Injected);
            assertTrue(((RoundThing) plainTire).packagePrivateMethod2Injected);
        }

        public void testOverriddingMixedWithPackagePrivate3() {
            assertFalse(spareTire.packagePrivateMethod3Injected);
            assertTrue(((Tire) spareTire).packagePrivateMethod3Injected);
            assertFalse(((RoundThing) spareTire).packagePrivateMethod3Injected);

            assertTrue(plainTire.packagePrivateMethod3Injected);
            assertTrue(((RoundThing) plainTire).packagePrivateMethod3Injected);
        }

        public void testOverriddingMixedWithPackagePrivate4() {
            assertFalse(plainTire.packagePrivateMethod4Injected);
            assertTrue(((RoundThing) plainTire).packagePrivateMethod4Injected);
        }

        // inject only once

        public void testOverriddenPackagePrivateMethodInjectedOnlyOnce() {
            assertFalse(engine.overriddenPackagePrivateMethodInjectedTwice);
        }

        public void testSimilarPackagePrivateMethodInjectedOnlyOnce() {
            assertFalse(spareTire.similarPackagePrivateMethodInjectedTwice);
        }

        public void testOverriddenProtectedMethodInjectedOnlyOnce() {
            assertFalse(spareTire.overriddenProtectedMethodInjectedTwice);
        }

        public void testOverriddenPublicMethodInjectedOnlyOnce() {
            assertFalse(spareTire.overriddenPublicMethodInjectedTwice);
        }

    }

    public static class StaticTests extends TestCase {

        public void testSubtypeStaticFieldsInjected() {
            assertTrue(SpareTire.hasBeenStaticFieldInjected());
        }

        public void testSubtypeStaticMethodsInjected() {
            assertTrue(SpareTire.hasBeenStaticMethodInjected());
        }

        public void testSupertypeStaticFieldsInjected() {
            assertTrue(Tire.hasBeenStaticFieldInjected());
        }

        public void testSupertypeStaticMethodsInjected() {
            assertTrue(Tire.hasBeenStaticMethodInjected());
        }

        public void testStaticFieldInjectionWithValues() {
            assertFalse("Expected unqualified value",
                    staticFieldPlainSeat instanceof DriversSeat);
            assertFalse("Expected unqualified value",
                    staticFieldPlainTire instanceof SpareTire);
            assertTrue("Expected qualified value",
                    staticFieldDriversSeat instanceof DriversSeat);
            assertTrue("Expected qualified value",
                    staticFieldSpareTire instanceof SpareTire);
        }

        public void testStaticMethodInjectionWithValues() {
            assertFalse("Expected unqualified value",
                    staticMethodPlainSeat instanceof DriversSeat);
            assertFalse("Expected unqualified value",
                    staticMethodPlainTire instanceof SpareTire);
            assertTrue("Expected qualified value",
                    staticMethodDriversSeat instanceof DriversSeat);
            assertTrue("Expected qualified value",
                    staticMethodSpareTire instanceof SpareTire);
        }

        public void testStaticFieldsInjectedBeforeMethods() {
            assertFalse(SpareTire.staticMethodInjectedBeforeStaticFields);
        }

        public void testSupertypeStaticMethodsInjectedBeforeSubtypeStaticFields() {
            assertFalse(SpareTire.subtypeStaticFieldInjectedBeforeSupertypeStaticMethods);
        }

        public void testSupertypeStaticMethodsInjectedBeforeSubtypeStaticMethods() {
            assertFalse(SpareTire.subtypeStaticMethodInjectedBeforeSupertypeStaticMethods);
        }

        public void testStaticFieldInjectionWithProviders() {
            assertFalse("Expected unqualified value",
                    staticFieldPlainSeatProviderDagger1.get() instanceof DriversSeat);
            assertFalse("Expected unqualified value",
                    staticFieldPlainTireProviderDagger1.get() instanceof SpareTire);
            assertTrue("Expected qualified value",
                    staticFieldDriversSeatProviderDagger1.get() instanceof DriversSeat);
            assertTrue("Expected qualified value",
                    staticFieldSpareTireProviderDagger1.get() instanceof SpareTire);
        }

        public void testStaticMethodInjectionWithProviders() {
            assertFalse("Expected unqualified value",
                    staticMethodPlainSeatProviderDagger1.get() instanceof DriversSeat);
            assertFalse("Expected unqualified value",
                    staticMethodPlainTireProviderDagger1.get() instanceof SpareTire);
            assertTrue("Expected qualified value",
                    staticMethodDriversSeatProviderDagger1.get() instanceof DriversSeat);
            assertTrue("Expected qualified value",
                    staticMethodSpareTireProviderDagger1.get() instanceof SpareTire);
        }
    }

    public static class PrivateTests extends TestCase {

        private final Convertible car = localConvertible.get();
        private final Engine engine = car.engineProviderDagger1.get();
        private final SpareTire spareTire = car.spareTire;

        public void testSupertypePrivateMethodInjected() {
            assertTrue(spareTire.superPrivateMethodInjected);
            assertTrue(spareTire.subPrivateMethodInjected);
        }

        public void testPackagePrivateMethodInjectedSamePackage() {
            assertTrue(engine.subPackagePrivateMethodInjected);
            assertFalse(engine.superPackagePrivateMethodInjected);
        }

        public void testPrivateMethodInjectedEvenWhenSimilarMethodLacksAnnotation() {
            assertTrue(spareTire.subPrivateMethodForOverrideInjected);
        }

        public void testSimilarPrivateMethodInjectedOnlyOnce() {
            assertFalse(spareTire.similarPrivateMethodInjectedTwice);
        }
    }
}
