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

import javax.inject.InjectDagger1;
import javax.inject.NamedDagger1;

public abstract class Engine {

    protected boolean publicNoArgsConstructorInjected;
    protected boolean subPackagePrivateMethodInjected;
    protected boolean superPackagePrivateMethodInjected;
    protected boolean subPackagePrivateMethodForOverrideInjected;
    protected boolean superPackagePrivateMethodForOverrideInjected;

    protected boolean overriddenTwiceWithOmissionInMiddleInjected;
    protected boolean overriddenTwiceWithOmissionInSubclassInjected;

    protected Seat seatA;
    protected Seat seatB;
    protected Tire tireA;
    protected Tire tireB;

    public boolean overriddenPackagePrivateMethodInjectedTwice;
    public boolean qualifiersInheritedFromOverriddenMethod;

    @InjectDagger1
    void injectPackagePrivateMethod() {
        superPackagePrivateMethodInjected = true;
    }

    @InjectDagger1
    void injectPackagePrivateMethodForOverride() {
        superPackagePrivateMethodForOverrideInjected = true;
    }

    @InjectDagger1
    public void injectQualifiers(@Drivers Seat seatA, Seat seatB,
                                 @NamedDagger1("spare") Tire tireA, Tire tireB) {
        if (!(seatA instanceof DriversSeat)
                || (seatB instanceof DriversSeat)
                || !(tireA instanceof SpareTire)
                || (tireB instanceof SpareTire)) {
            qualifiersInheritedFromOverriddenMethod = true;
        }
    }

    @InjectDagger1
    public void injectTwiceOverriddenWithOmissionInMiddle() {
        overriddenTwiceWithOmissionInMiddleInjected = true;
    }

    @InjectDagger1
    public void injectTwiceOverriddenWithOmissionInSubclass() {
        overriddenTwiceWithOmissionInSubclassInjected = true;
    }
}
