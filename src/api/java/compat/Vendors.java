/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

package compat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.SOURCE)
@Target({TYPE, FIELD, METHOD, CONSTRUCTOR, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE})
public @interface Vendors {
    Vendor[] value() default {};
}
