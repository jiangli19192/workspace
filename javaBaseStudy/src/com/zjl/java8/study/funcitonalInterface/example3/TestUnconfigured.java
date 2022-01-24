package com.zjl.java8.study.funcitonalInterface.example3;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public class TestUnconfigured {
    @Test
    public void testOnlyHaveOption() {
        List<Feature> list = Lists.newArrayList(new Option("FC01", "OP01"));
        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 1));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testOnlyHaveOptionBundle() {
        List<Feature> list = Lists.newArrayList(new OptionBundle("FC01", "OB01"));

        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 1));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndSingleOptionBundleWhenOptionCodeDifferentOptionBundleCode() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC01", "OB01");
        List<Feature> list = Lists.newArrayList(option, optionBundle);

        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 1));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndSingleOptionBundleWhenOptionCodeEqualsOptionBundleCode() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC01", "OP01");
        List<Feature> list = Lists.newArrayList(option, optionBundle);

        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 1));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndSingleOptionBundleWhenOptionCodeEqualsOptionBundleCodeButFeatureCodeDifferent() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC02", "OP01");
        List<Feature> list = Lists.newArrayList(option, optionBundle);

        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 1));
        featureCharacterMap.put("FC02", new Character("Character01", 1));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndSingleOptionBundleWhenOptionCodeEqualsOptionBundleCodeAndBelongToCharacterDifferentButFeatureCodeDifferent_1() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC02", "OP01");
        List<Feature> list = Lists.newArrayList(option, optionBundle);

        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 1));
        featureCharacterMap.put("FC02", new Character("Character02", 2));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndSingleOptionBundleWhenOptionCodeEqualsOptionBundleCodeAndBelongToCharacterDifferentButFeatureCodeDifferent_2() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC02", "OP01");
        List<Feature> list = Lists.newArrayList(option, optionBundle);

        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 2));
        featureCharacterMap.put("FC02", new Character("Character02", 1));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndMultiOptionBundleWhenTwoFeatureBelongToSameCharacter() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC01", "OB01");
        OptionBundle optionBundle2 = new OptionBundle("FC02", "OB01");
        List<Feature> list = Lists.newArrayList(option, optionBundle, optionBundle2);
        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 1));
        featureCharacterMap.put("FC02", new Character("Character01", 1));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndMultiOptionBundleWhenTwoFeatureBelongToSameCharacter_And_OptionCodeEqualsOptionBundleCode() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC01", "OP01");
        OptionBundle optionBundle2 = new OptionBundle("FC02", "OP01");
        List<Feature> list = Lists.newArrayList(option, optionBundle, optionBundle2);
        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 1));
        featureCharacterMap.put("FC02", new Character("Character01", 1));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndMultiOptionBundleWhenTwoFeatureBelongToSameCharacter_And_OptionCodeEqualsOptionBundleCode_And_BelongtToDifferentCharacter_1() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC01", "OP01");
        OptionBundle optionBundle2 = new OptionBundle("FC02", "OP01");
        List<Feature> list = Lists.newArrayList(option, optionBundle, optionBundle2);
        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 1));
        featureCharacterMap.put("FC02", new Character("Character02", 2));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndMultiOptionBundleWhenTwoFeatureBelongToSameCharacter_And_OptionCodeEqualsOptionBundleCode_And_BelongtToDifferentCharacter_2() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC01", "OP01");
        OptionBundle optionBundle2 = new OptionBundle("FC02", "OP01");
        List<Feature> list = Lists.newArrayList(option, optionBundle, optionBundle2);
        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 2));
        featureCharacterMap.put("FC02", new Character("Character02", 1));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndMultiOptionBundleWhenTwoFeatureBelongToDifferentCharacter_1() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC01", "OB01");
        OptionBundle optionBundle2 = new OptionBundle("FC02", "OB01");
//        List<Feature> list = Lists.newArrayList(option, optionBundle, optionBundle2);
        List<Feature> list = Lists.newArrayList(optionBundle, optionBundle2, option);
        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 1));
        featureCharacterMap.put("FC02", new Character("Character02", 2));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    @Test
    public void testHaveOptionAndMultiOptionBundleWhenTwoFeatureBelongToDifferentCharacter_2() {
        Option option = new Option("FC01", "OP01");
        OptionBundle optionBundle = new OptionBundle("FC01", "OB01");
        OptionBundle optionBundle2 = new OptionBundle("FC02", "OB01");
        List<Feature> list = Lists.newArrayList(option, optionBundle, optionBundle2);
        list = getListFromProductService(list);

        Map<String, Character> featureCharacterMap = Maps.newHashMap();
        featureCharacterMap.put("FC01", new Character("Character01", 2));
        featureCharacterMap.put("FC02", new Character("Character02", 1));

        list = groupFeaturesAndSetCharacterName(featureCharacterMap, list);

        iterateList(list);
    }

    private List<Feature> groupFeaturesAndSetCharacterName(Map<String, Character> featureCharacterMap, List<Feature> rawFeatures) {
        Map<String, List<Feature>> optionFeatureMapping = rawFeatures.stream()
            .filter(f -> Objects.nonNull(featureCharacterMap.get(f.getFeatureCode())))
            .collect(groupingBy(Feature::getOptionCode));
        return optionFeatureMapping.values().stream()
            .filter(features -> isNotEmpty(features))
            .map(features -> getHighestPriorityFeatureAndSetCharacterName(featureCharacterMap, features))
            .collect(toList());
    }

    private Feature getHighestPriorityFeatureAndSetCharacterName(Map<String, Character> featureCharacterMap, List<Feature> features) {
        if (features.size() == 1) {
            return getFeatureAfterSetCharacterName(featureCharacterMap, features.get(0));
        }
        Collections.sort(features, Comparator.comparingInt(f -> featureCharacterMap.get(f.getFeatureCode()).getSequence()));
        return getFeatureAfterSetCharacterName(featureCharacterMap, features.get(0));
    }

    private Feature getFeatureAfterSetCharacterName(Map<String, Character> featureCharacterMap, Feature feature) {
        Character character = featureCharacterMap.get(feature.getFeatureCode());
        feature.setCharacterName(character.getName());
        return feature;
    }

    private List<Feature> getListFromProductService(List<Feature> list) {
        return list.stream()
            .filter(distinctByKey(feature -> feature.getFeatureCode() + ":" + feature.getOptionCode()))
            .sorted(Comparator.comparing(Feature::getFeatureCode))
            .collect(toList());
    }

    private void iterateList(List<Feature> list) {
        list.stream()
            .filter(distinctByKey(feature -> feature.getFeatureCode() + ":" + feature.getOptionCode()))
            .sorted(Comparator.comparing(Feature::getFeatureCode))
            .forEach(feature -> printInfo(feature));

        System.out.println("---------------------------");
    }

    public <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private void printInfo(Feature feature) {
        System.out.println("FeatureCode:" + feature.getFeatureCode() + "; OptionCode:" + feature.getOptionCode() + "; Type:" + feature.getType());
    }
}
