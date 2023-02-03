package com.allen.photoAlbum.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Photo implements Serializable {
    private @Getter @Setter Integer albumId;
    private @Getter @Setter Integer id;
    private @Getter @Setter String title;
    private @Getter @Setter String url;
    private @Getter @Setter String thumbnailUrl;
}
