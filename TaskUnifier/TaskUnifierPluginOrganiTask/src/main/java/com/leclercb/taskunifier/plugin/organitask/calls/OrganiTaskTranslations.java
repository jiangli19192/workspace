/*
 * TaskUnifier
 * Copyright (c) 2013, Benjamin Leclerc
 * All rights reserved.
 */
package com.leclercb.taskunifier.plugin.organitask.calls;

import com.leclercb.taskunifier.api.models.Model;
import com.leclercb.taskunifier.api.models.ModelId;
import com.leclercb.taskunifier.api.models.ModelType;
import com.leclercb.taskunifier.api.models.enums.GoalLevel;
import com.leclercb.taskunifier.api.models.enums.TaskPriority;
import com.leclercb.taskunifier.api.models.enums.TaskRepeatFrom;
import com.leclercb.taskunifier.api.models.utils.ModelFactoryUtils;
import com.leclercb.taskunifier.gui.plugins.PluginApi;

import java.awt.*;
import java.util.Calendar;

final class OrganiTaskTranslations {

    private OrganiTaskTranslations() {

    }

    public static Calendar translateUTCDate(Long timeStamp) {
        if (timeStamp == null || timeStamp == 0)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp * 1000);
        return calendar;
    }

    public static Long translateUTCDate(Calendar calendar) {
        if (calendar == null)
            return null;

        return calendar.getTimeInMillis() / 1000;
    }

    public static Color translateColor(String color) {
        if (color == null || color.length() == 0)
            return null;

        try {
            if (!color.startsWith("#"))
                color = '#' + color;

            return Color.decode(color);
        } catch (Exception e) {
            return null;
        }
    }

    public static String translateColor(Color color) {
        if (color == null)
            return null;

        String rgb = Integer.toHexString(color.getRGB());
        return rgb.substring(2, rgb.length()).toUpperCase();
    }

    public static GoalLevel translateGoalLevel(String level) {
        if ("SHORT".equals(level))
            return GoalLevel.SHORT_TERM;

        if ("MEDIUM".equals(level))
            return GoalLevel.SHORT_TERM;

        if ("LONG".equals(level))
            return GoalLevel.LONG_TERM;

        if ("LIFE".equals(level))
            return GoalLevel.LIFE_TIME;

        return GoalLevel.SHORT_TERM;
    }

    public static String translateGoalLevel(GoalLevel level) {
        if (level == GoalLevel.SHORT_TERM)
            return "SHORT";

        if (level == GoalLevel.LONG_TERM)
            return "LONG";

        if (level == GoalLevel.LIFE_TIME)
            return "LIFE";

        return "SHORT";
    }

    public static TaskRepeatFrom translateTaskRepeatFrom(String repeatFrom) {
        return TaskRepeatFrom.valueOf(repeatFrom);
    }

    public static String translateTaskRepeatFrom(TaskRepeatFrom repeatFrom) {
        return repeatFrom.name();
    }

    public static TaskPriority translateTaskPriority(String priority) {
        return TaskPriority.valueOf(priority);
    }

    public static String translateTaskPriority(TaskPriority priority) {
        return priority.name();
    }

    public static ModelId getModelOrCreateShell(
            final ModelType modelType,
            final String foreignId) {
        if (foreignId == null || foreignId.length() == 0)
            return null;

        Model model = ModelFactoryUtils.getFactory(modelType).get(
                "organitask",
                foreignId);

        if (model == null) {
            PluginApi.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    Model model = ModelFactoryUtils.getFactory(modelType).createShell(
                            new ModelId());
                    model.addModelReferenceId("organitask", foreignId);
                }

            });

            model = ModelFactoryUtils.getFactory(modelType).get(
                    "organitask",
                    foreignId);
        }

        return (model == null ? null : model.getModelId());
    }

}
