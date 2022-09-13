    -- Table: public.episode_

    -- DROP TABLE IF EXISTS public.episode_;

    CREATE TABLE IF NOT EXISTS public.episode_
    (
        id character varying(255) COLLATE pg_catalog."default" NOT NULL,
        author text COLLATE pg_catalog."default",
        "contentLength" bigint,
        contenttype text COLLATE pg_catalog."default",
        created timestamp with time zone,
        deleted boolean,
        description text COLLATE pg_catalog."default",
        duration double precision,
        "episodeNumber" text COLLATE pg_catalog."default",
        "episodeType" text COLLATE pg_catalog."default",
        hosted boolean,
        image text COLLATE pg_catalog."default",
        "imageTitle" text COLLATE pg_catalog."default",
        "lastPublished" text COLLATE pg_catalog."default",
        link text COLLATE pg_catalog."default",
        "mediaUrl" text COLLATE pg_catalog."default",
        modified timestamp with time zone,
        name text COLLATE pg_catalog."default",
        "partitionKey" character varying(255) COLLATE pg_catalog."default",
        "publishingDate" text COLLATE pg_catalog."default",
        rating character varying(255) COLLATE pg_catalog."default",
        "rssGuid" text COLLATE pg_catalog."default",
        "rssLink" text COLLATE pg_catalog."default",
        "seasonNumber" integer,
        "showId" character varying(255) COLLATE pg_catalog."default",
        "sourceMediaFilename" text COLLATE pg_catalog."default",
        "sourceMediaUrl" text COLLATE pg_catalog."default",
        subtitle text COLLATE pg_catalog."default",
        summary text COLLATE pg_catalog."default",
        tags json,
        timeline json,
        "sourceMediaUrls" json,
        permissions json,
        keywords json,
        body json,
        categories json,
        "adSettings" json,
        original json,
        type character varying(255) COLLATE pg_catalog."default",
        url text COLLATE pg_catalog."default",
        CONSTRAINT episode__pkey PRIMARY KEY (id)
        )

        TABLESPACE pg_default;

    ALTER TABLE IF EXISTS public.episode_
        OWNER to postgres;