PGDMP             
            {            spring_webcodein_admin    15.1    15.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            	           1262    261776    spring_webcodein_admin    DATABASE     �   CREATE DATABASE spring_webcodein_admin WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1256';
 &   DROP DATABASE spring_webcodein_admin;
                postgres    false                        2615    261798    administration_schema    SCHEMA     %   CREATE SCHEMA administration_schema;
 #   DROP SCHEMA administration_schema;
                postgres    false            �            1259    261800    user    TABLE     �  CREATE TABLE administration_schema."user" (
    id bigint NOT NULL,
    created_by character varying(255),
    created_on timestamp(6) without time zone,
    modified_by character varying(255),
    updated_on timestamp(6) without time zone,
    email character varying(100) NOT NULL,
    firstname character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    username character varying(255)
);
 )   DROP TABLE administration_schema."user";
       administration_schema         heap    postgres    false    6            �            1259    261799    user_id_seq    SEQUENCE     �   CREATE SEQUENCE administration_schema.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE administration_schema.user_id_seq;
       administration_schema          postgres    false    217    6            
           0    0    user_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE administration_schema.user_id_seq OWNED BY administration_schema."user".id;
          administration_schema          postgres    false    216            �            1259    261777    room    TABLE     �   CREATE TABLE public.room (
    room_id bigint NOT NULL,
    bed_info character varying(255),
    room_name character varying(255),
    room_number character varying(255)
);
    DROP TABLE public.room;
       public         heap    postgres    false            j           2604    261803    user id    DEFAULT     �   ALTER TABLE ONLY administration_schema."user" ALTER COLUMN id SET DEFAULT nextval('administration_schema.user_id_seq'::regclass);
 G   ALTER TABLE administration_schema."user" ALTER COLUMN id DROP DEFAULT;
       administration_schema          postgres    false    217    216    217                      0    261800    user 
   TABLE DATA           �   COPY administration_schema."user" (id, created_by, created_on, modified_by, updated_on, email, firstname, last_name, username) FROM stdin;
    administration_schema          postgres    false    217                    0    261777    room 
   TABLE DATA           I   COPY public.room (room_id, bed_info, room_name, room_number) FROM stdin;
    public          postgres    false    215   @                  0    0    user_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('administration_schema.user_id_seq', 1, true);
          administration_schema          postgres    false    216            n           2606    261809 !   user uk_ob8kqyqqgmefl0aco34akdtpe 
   CONSTRAINT     n   ALTER TABLE ONLY administration_schema."user"
    ADD CONSTRAINT uk_ob8kqyqqgmefl0aco34akdtpe UNIQUE (email);
 \   ALTER TABLE ONLY administration_schema."user" DROP CONSTRAINT uk_ob8kqyqqgmefl0aco34akdtpe;
       administration_schema            postgres    false    217            p           2606    261811 !   user uk_sb8bbouer5wak8vyiiy4pf2bx 
   CONSTRAINT     q   ALTER TABLE ONLY administration_schema."user"
    ADD CONSTRAINT uk_sb8bbouer5wak8vyiiy4pf2bx UNIQUE (username);
 \   ALTER TABLE ONLY administration_schema."user" DROP CONSTRAINT uk_sb8bbouer5wak8vyiiy4pf2bx;
       administration_schema            postgres    false    217            r           2606    261807    user user_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY administration_schema."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);
 I   ALTER TABLE ONLY administration_schema."user" DROP CONSTRAINT user_pkey;
       administration_schema            postgres    false    217            l           2606    261783    room room_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (room_id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public            postgres    false    215                  x�3��C���t���4�J� �=... �-9            x������ � �     