package com.jdc.pattern.generics;

public record Pair<K,T>(K key, T value) implements PairInf<T, K> {

}
