package de.hglabor.blockshuffle;

import net.minecraft.tag.Tag;
import net.minecraft.util.registry.Registry;

import java.util.stream.Stream;

public class ObjectBuilderTags<T>  {
    private final Tag.Builder tagBuilder;
    private final Registry<T> registry;
    private final String string;

    public ObjectBuilderTags(Tag.Builder builder, Registry<T> registry, String string) {
        this.tagBuilder = builder;
        this.registry = registry;
        this.string = string;
    }

    public ObjectBuilderTags<T> add(T element) {
        this.tagBuilder.add(this.registry.getId(element), this.string);
        return this;
    }

    public ObjectBuilderTags<T> addTag(Tag.Identified<T> identifiedTag) {
        this.tagBuilder.addTag(identifiedTag.getId(), this.string);
        return this;
    }

    @SafeVarargs
    public final ObjectBuilderTags<T> add(T... objects) {
        Stream var10000 = Stream.of(objects);
        Registry var10001 = this.registry;
        var10001.getClass();
        var10000.map(var10001::getId).forEach((identifier) -> {
            this.tagBuilder.add((Tag.Entry) identifier, this.string);
        });
        return this;
    }
}