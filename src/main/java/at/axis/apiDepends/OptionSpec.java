package at.axis.apiDepends;

import net.dv8tion.jda.api.interactions.commands.OptionType;

import java.util.LinkedHashMap;
import java.util.Map;

public class OptionSpec {
    public final OptionType type;
    public final String name;
    public final String description;
    public final boolean required;
    public final Map<String, String> choices = new LinkedHashMap<>();

    public OptionSpec(OptionType type, String name, String description, boolean required) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.required = required;
    }

    public OptionSpec addChoice(String name, String value) {
        choices.put(name, value);
        return this;
    }
}
