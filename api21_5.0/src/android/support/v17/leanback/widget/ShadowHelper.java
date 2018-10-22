/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package android.support.v17.leanback.widget;

import android.os.Build;
import android.view.ViewGroup;
import android.view.View;


/**
 * Helper for shadow.
 */
final class ShadowHelper {

    final static ShadowHelper sInstance = new ShadowHelper();
    boolean mSupportsShadow;
    boolean mUsesZShadow;
    ShadowHelperVersionImpl mImpl;

    /**
     * Interface implemented by classes that support Shadow.
     */
    static interface ShadowHelperVersionImpl {

        public void prepareParent(ViewGroup parent);

        public Object addShadow(ViewGroup shadowContainer, boolean roundedCorners);

        public void setZ(View view, float z);

        public void setShadowFocusLevel(Object impl, float level);

    }

    /**
     * Interface used when we do not support Shadow animations.
     */
    private static final class ShadowHelperStubImpl implements ShadowHelperVersionImpl {

        @Override
        public void prepareParent(ViewGroup parent) {
            // do nothing
        }

        @Override
        public Object addShadow(ViewGroup shadowContainer, boolean roundedCorners) {
            // do nothing
            return null;
        }

        @Override
        public void setShadowFocusLevel(Object impl, float level) {
            // do nothing
        }

        @Override
        public void setZ(View view, float z) {
            // do nothing
        }

    }

    /**
     * Implementation used on JBMR2 (and above).
     */
    private static final class ShadowHelperJbmr2Impl implements ShadowHelperVersionImpl {

        @Override
        public void prepareParent(ViewGroup parent) {
            ShadowHelperJbmr2.prepareParent(parent);
        }

        @Override
        public Object addShadow(ViewGroup shadowContainer, boolean roundedCorners) {
            // Rounded corners not supported
            return ShadowHelperJbmr2.addShadow(shadowContainer);
        }

        @Override
        public void setShadowFocusLevel(Object impl, float level) {
            ShadowHelperJbmr2.setShadowFocusLevel(impl, level);
        }

        @Override
        public void setZ(View view, float z) {
            // Not supported
        }

    }

    /**
     * Implementation used on api 21 (and above).
     */
    private static final class ShadowHelperApi21Impl implements ShadowHelperVersionImpl {

        @Override
        public void prepareParent(ViewGroup parent) {
            // do nothing
        }

        @Override
        public Object addShadow(ViewGroup shadowContainer, boolean roundedCorners) {
            return ShadowHelperApi21.addShadow(shadowContainer, roundedCorners);
        }

        @Override
        public void setShadowFocusLevel(Object impl, float level) {
            ShadowHelperApi21.setShadowFocusLevel(impl, level);
        }

        @Override
        public void setZ(View view, float z) {
            ShadowHelperApi21.setZ(view, z);
        }

    }

    /**
     * Returns the ShadowHelper.
     */
    private ShadowHelper() {
        if (Build.VERSION.SDK_INT >= 21) {
            mSupportsShadow = true;
            mUsesZShadow = true;
            mImpl = new ShadowHelperApi21Impl();
        } else if (Build.VERSION.SDK_INT >= 18) {
            mSupportsShadow = true;
            mImpl = new ShadowHelperJbmr2Impl();
        } else {
            mSupportsShadow = false;
            mImpl = new ShadowHelperStubImpl();
        }
    }

    public static ShadowHelper getInstance() {
        return sInstance;
    }

    public boolean supportsShadow() {
        return mSupportsShadow;
    }

    public boolean usesZShadow() {
        return mUsesZShadow;
    }

    public void prepareParent(ViewGroup parent) {
        mImpl.prepareParent(parent);
    }

    public Object addShadow(ViewGroup shadowContainer, boolean roundedCorners) {
        return mImpl.addShadow(shadowContainer, roundedCorners);
    }

    public void setShadowFocusLevel(Object impl, float level) {
        mImpl.setShadowFocusLevel(impl, level);
    }

    /**
     * Set the view z coordinate.
     */
    public void setZ(View view, float z) {
        mImpl.setZ(view, z);
    }

}