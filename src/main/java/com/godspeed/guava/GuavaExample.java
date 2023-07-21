package com.godspeed.guava;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.godspeed.springBoot.entity.Book;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.primitives.Ints;

public class GuavaExample {
    
    public static void main(String[] args) {
        // testMultimap();
        // testSplitter();
        // testCharMatcher();
        // testJoiner();
        // testMoreObjects();
        // testStrings();
        // testTable();
        // testBiMap();
        // testSortedMap();
        // List<String> test = null;
        // add(test);
        // getBooks();
        // testFilter();
        testSet();
    }
    
    static void testFilter() {
        ArrayList<String> list = Lists.newArrayList("java", "ptt", "javaScript", "python", "json");
        
        Collection<String> result = Collections2.filter(list, (e) -> e.endsWith("t"));
        result.forEach(System.out::println);
    }
    
    static void testSet() {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> set2 = Sets.newHashSet(3, 4, 5);
        Sets.SetView<Integer> intersection = Sets.intersection(set1, set2);
        intersection.forEach(System.out::println);
        
        Sets.SetView<Integer> difference = Sets.difference(set1, set2);
        difference.forEach(System.out::println);
        
        Sets.SetView<Integer> union = Sets.union(set1, set2);
        union.forEach(System.out::println);
    }
    
    static void testStrings() {
        String test = null;
        test = Strings.nullToEmpty(test);
        System.out.println(test);
    }
    
    static void testJoiner() {
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        String result = Joiner.on(",").join(list);
        System.out.println(result);
        
        Map<String, Integer> map = Maps.newHashMap();
        map.put("xiaoming", 12);
        map.put("xiaohong", 13);
        String result2 = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(result2);
        
    }
    
    static void testMoreObjects() {
        Book a = new Book("Genesis", "Moss", 100);
        String str = MoreObjects.toStringHelper("Book").add("name", a.getName()).toString();
        System.out.println(str);
        
        Integer value = 888;
        int x = value == null ? 777 : value;
        int id = MoreObjects.firstNonNull(value, 777);
        System.out.println(id);
        
    }
    
    static void testCollections() {
        List<Integer> numbers = Ints.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet();
        Map<String, String> map = Maps.newHashMap();
    }
    
    static void testCharMatcher() {
        String letterAndNumber = "1234abcdABCD56789";
        String number = CharMatcher.inRange('0', '9').retainFrom(letterAndNumber);
        String abc = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).retainFrom(letterAndNumber);
        System.out.println(number);
        System.out.println(abc);
    }
    
    static void testSplitter() {
        String str = "1,2,3,4,5,6";
        List<String> list = Splitter.on(",").splitToList(str);
        
        String str2 = "xiaoming=11,xiaohong=23";
        Map<String, String> map = Splitter.on(",").withKeyValueSeparator("=").split(str2);
        
        String str3 = "1-2-3-4-  5-  6   ";
        List<String> list3 = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str3);
        
        String input = "aa.dd,,ff,,.";
        List<String> result = Splitter.onPattern("[.|,]").omitEmptyStrings().splitToList(input);
        
        System.out.println(list);
    }
    
    static void testMultimap() {
        Multimap<String, Integer> map = ArrayListMultimap.create();
        map.put("John", 30);
        map.put("John", 50);
        System.out.println(map.get("John"));
        
        Multimap<String, String> map2 = ArrayListMultimap.create();
        map2.put("John", "AAA");
        map2.put("John", "XXX");
        System.out.println(map2.get("John"));
        
    }
    
    static void testSortedMap() {
        ImmutableSortedMap<String, Integer> sortedMap = new ImmutableSortedMap.Builder<String, Integer>(Ordering.natural())
                .put("John", 1000)
                .put("Jane", 1500)
                .put("Adam", 2000)
                .put("Tom", 2000)
                .build();
        
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastEntry().getValue());
    }
    
    static void testBiMap() {
        BiMap<String, String> capitalCountryBiMap = HashBiMap.create();
        capitalCountryBiMap.put("New Delhi", "India");
        capitalCountryBiMap.put("Washington, D.C.", "USA");
        capitalCountryBiMap.put("Moscow", "Russia");
        
        String keyFromBiMap = capitalCountryBiMap.inverse().get("Russia");
        String valueFromBiMap = capitalCountryBiMap.get("Washington, D.C.");
        
        System.out.println(keyFromBiMap);
        System.out.println(valueFromBiMap);
    }
    
    static void testTable() {
        Table<String, String, Integer> universityCourseSeatTable = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);
        
        int seatCount = universityCourseSeatTable.get("Mumbai", "IT");
        Integer seatCountForNoEntry = universityCourseSeatTable.get("Harvard", "IT");
        System.out.println("seatCount:" + seatCount);
        System.out.println("seatCountForNoEntry:" + seatCountForNoEntry);
        
        Map<String, Map<String, Integer>> courseKeyUniversitySeatMap = universityCourseSeatTable.columnMap();
    }
    
    static List<Book> getBooks() {
        Book a = new Book("Genesis", "Moss", 100);
        Book b = new Book("Exodus", "Moss", 110);
        Book c = new Book("Leviticus", "Moss", 120);
        Book d = new Book("Numbers", "Moss", 130);
        Book e = new Book("Deuteronomy", "Moss", 140);
        Book f = new Book("Joshua", "Joshua", 140);
        
        List<Book> books = Lists.newArrayList(a, b, c, d, e, f);
        Collections.sort(books);
        return books;
    }
    
    static <T> void add(List<T> lt) {
        try {
            checkNotNull(lt, "不能傳入 null");
            checkArgument(!lt.isEmpty(), "List 不能是空");
            checkState(lt.size() <= 2, "超過負載");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
