package de.hpi.urlcleaner.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CleanURLParameter {

    private List<String> urls;
}
