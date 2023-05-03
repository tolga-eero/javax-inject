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

package org.atinject.tck.auto.accessories;

import org.atinject.tck.auto.FuelTank;
import org.atinject.tck.auto.Tire;

import javax.inject.InjectDagger1;

public class SpareTire extends Tire {

    FuelTank constructorInjection = NEVER_INJECTED;
    @InjectDagger1
    FuelTank fieldInjection = NEVER_INJECTED;
    FuelTank methodInjection = NEVER_INJECTED;
    @InjectDagger1
    static FuelTank staticFieldInjection = NEVER_INJECTED;
    static FuelTank staticMethodInjection = NEVER_INJECTED;

    @InjectDagger1
    public SpareTire(FuelTank forSupertype, FuelTank forSubtype) {
        super(forSupertype);
        this.constructorInjection = forSubtype;
    }

    @InjectDagger1
    void subtypeMethodInjection(FuelTank methodInjection) {
        if (!hasSpareTireBeenFieldInjected()) {
            methodInjectedBeforeFields = true;
        }
        this.methodInjection = methodInjection;
    }

    @InjectDagger1
    static void subtypeStaticMethodInjection(FuelTank methodInjection) {
        if (!hasBeenStaticFieldInjected()) {
            staticMethodInjectedBeforeStaticFields = true;
        }
        staticMethodInjection = methodInjection;
    }

    @InjectDagger1
    private void injectPrivateMethod() {
        if (subPrivateMethodInjected) {
            similarPrivateMethodInjectedTwice = true;
        }
        subPrivateMethodInjected = true;
    }

    @InjectDagger1
    void injectPackagePrivateMethod() {
        if (subPackagePrivateMethodInjected) {
            similarPackagePrivateMethodInjectedTwice = true;
        }
        subPackagePrivateMethodInjected = true;
    }

    @InjectDagger1
    protected void injectProtectedMethod() {
        if (subProtectedMethodInjected) {
            overriddenProtectedMethodInjectedTwice = true;
        }
        subProtectedMethodInjected = true;
    }

    @InjectDagger1
    public void injectPublicMethod() {
        if (subPublicMethodInjected) {
            overriddenPublicMethodInjectedTwice = true;
        }
        subPublicMethodInjected = true;
    }

    private void injectPrivateMethodForOverride() {
        superPrivateMethodForOverrideInjected = true;
    }

    void injectPackagePrivateMethodForOverride() {
        superPackagePrivateMethodForOverrideInjected = true;
    }

    protected void injectProtectedMethodForOverride() {
        protectedMethodForOverrideInjected = true;
    }

    public void injectPublicMethodForOverride() {
        publicMethodForOverrideInjected = true;
    }

    public boolean hasSpareTireBeenFieldInjected() {
        return fieldInjection != NEVER_INJECTED;
    }

    public boolean hasSpareTireBeenMethodInjected() {
        return methodInjection != NEVER_INJECTED;
    }

    public static boolean hasBeenStaticFieldInjected() {
        return staticFieldInjection != NEVER_INJECTED;
    }

    public static boolean hasBeenStaticMethodInjected() {
        return staticMethodInjection != NEVER_INJECTED;
    }

    public boolean packagePrivateMethod2Injected;

    @InjectDagger1
    void injectPackagePrivateMethod2() {
        packagePrivateMethod2Injected = true;
    }

    public boolean packagePrivateMethod3Injected;

    void injectPackagePrivateMethod3() {
        packagePrivateMethod3Injected = true;
    }
}
