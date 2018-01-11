package de.hpi.urlcleaner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CleanURLResponse {

    private boolean blacklisted;
    private String cleanURL;
}
