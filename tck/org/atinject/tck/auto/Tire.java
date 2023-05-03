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

import org.atinject.tck.auto.accessories.SpareTire;
import org.atinject.tck.auto.accessories.RoundThing;

import javax.inject.InjectDagger1;
import java.util.LinkedHashSet;
import java.util.Set;

public class Tire extends RoundThing {

    protected static final FuelTank NEVER_INJECTED = new FuelTank();

    protected static final Set<String> moreProblems = new LinkedHashSet<String>();

    FuelTank constructorInjection = NEVER_INJECTED;
    @InjectDagger1
    FuelTank fieldInjection = NEVER_INJECTED;
    FuelTank methodInjection = NEVER_INJECTED;
    @InjectDagger1
    static FuelTank staticFieldInjection = NEVER_INJECTED;
    static FuelTank staticMethodInjection = NEVER_INJECTED;

    boolean constructorInjected;

    protected boolean superPrivateMethodInjected;
    protected boolean superPackagePrivateMethodInjected;
    protected boolean superProtectedMethodInjected;
    protected boolean superPublicMethodInjected;
    protected boolean subPrivateMethodInjected;
    protected boolean subPackagePrivateMethodInjected;
    protected boolean subProtectedMethodInjected;
    protected boolean subPublicMethodInjected;

    protected boolean superPrivateMethodForOverrideInjected;
    protected boolean superPackagePrivateMethodForOverrideInjected;
    protected boolean subPrivateMethodForOverrideInjected;
    protected boolean subPackagePrivateMethodForOverrideInjected;
    protected boolean protectedMethodForOverrideInjected;
    protected boolean publicMethodForOverrideInjected;

    public boolean methodInjectedBeforeFields;
    public boolean subtypeFieldInjectedBeforeSupertypeMethods;
    public boolean subtypeMethodInjectedBeforeSupertypeMethods;
    public static boolean staticMethodInjectedBeforeStaticFields;
    public static boolean subtypeStaticFieldInjectedBeforeSupertypeStaticMethods;
    public static boolean subtypeStaticMethodInjectedBeforeSupertypeStaticMethods;
    public boolean similarPrivateMethodInjectedTwice;
    public boolean similarPackagePrivateMethodInjectedTwice;
    public boolean overriddenProtectedMethodInjectedTwice;
    public boolean overriddenPublicMethodInjectedTwice;

    @InjectDagger1
    public Tire(FuelTank constructorInjection) {
        this.constructorInjection = constructorInjection;
    }

    @InjectDagger1
    void supertypeMethodInjection(FuelTank methodInjection) {
        if (!hasTireBeenFieldInjected()) {
            methodInjectedBeforeFields = true;
        }
        if (hasSpareTireBeenFieldInjected()) {
            subtypeFieldInjectedBeforeSupertypeMethods = true;
        }
        if (hasSpareTireBeenMethodInjected()) {
            subtypeMethodInjectedBeforeSupertypeMethods = true;
        }
        this.methodInjection = methodInjection;
    }

    @InjectDagger1
    static void supertypeStaticMethodInjection(FuelTank methodInjection) {
        if (!Tire.hasBeenStaticFieldInjected()) {
            staticMethodInjectedBeforeStaticFields = true;
        }
        if (SpareTire.hasBeenStaticFieldInjected()) {
            subtypeStaticFieldInjectedBeforeSupertypeStaticMethods = true;
        }
        if (SpareTire.hasBeenStaticMethodInjected()) {
            subtypeStaticMethodInjectedBeforeSupertypeStaticMethods = true;
        }
        staticMethodInjection = methodInjection;
    }

    @InjectDagger1
    private void injectPrivateMethod() {
        if (superPrivateMethodInjected) {
            similarPrivateMethodInjectedTwice = true;
        }
        superPrivateMethodInjected = true;
    }

    @InjectDagger1
    void injectPackagePrivateMethod() {
        if (superPackagePrivateMethodInjected) {
            similarPackagePrivateMethodInjectedTwice = true;
        }
        superPackagePrivateMethodInjected = true;
    }

    @InjectDagger1
    protected void injectProtectedMethod() {
        if (superProtectedMethodInjected) {
            overriddenProtectedMethodInjectedTwice = true;
        }
        superProtectedMethodInjected = true;
    }

    @InjectDagger1
    public void injectPublicMethod() {
        if (superPublicMethodInjected) {
            overriddenPublicMethodInjectedTwice = true;
        }
        superPublicMethodInjected = true;
    }

    @InjectDagger1
    private void injectPrivateMethodForOverride() {
        subPrivateMethodForOverrideInjected = true;
    }

    @InjectDagger1
    void injectPackagePrivateMethodForOverride() {
        subPackagePrivateMethodForOverrideInjected = true;
    }

    @InjectDagger1
    protected void injectProtectedMethodForOverride() {
        protectedMethodForOverrideInjected = true;
    }

    @InjectDagger1
    public void injectPublicMethodForOverride() {
        publicMethodForOverrideInjected = true;
    }

    protected final boolean hasTireBeenFieldInjected() {
        return fieldInjection != NEVER_INJECTED;
    }

    protected boolean hasSpareTireBeenFieldInjected() {
        return false;
    }

    protected final boolean hasTireBeenMethodInjected() {
        return methodInjection != NEVER_INJECTED;
    }

    protected static boolean hasBeenStaticFieldInjected() {
        return staticFieldInjection != NEVER_INJECTED;
    }

    protected static boolean hasBeenStaticMethodInjected() {
        return staticMethodInjection != NEVER_INJECTED;
    }

    protected boolean hasSpareTireBeenMethodInjected() {
        return false;
    }

    boolean packagePrivateMethod2Injected;

    @InjectDagger1
    void injectPackagePrivateMethod2() {
        packagePrivateMethod2Injected = true;
    }

    public boolean packagePrivateMethod3Injected;

    @InjectDagger1
    void injectPackagePrivateMethod3() {
        packagePrivateMethod3Injected = true;
    }

    public boolean packagePrivateMethod4Injected;

    void injectPackagePrivateMethod4() {
        packagePrivateMethod4Injected = true;
    }
}
