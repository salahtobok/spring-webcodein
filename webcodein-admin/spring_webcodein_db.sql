PGDMP     -    4                {            spring_webcodein_admin    15.1    15.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    261776    spring_webcodein_admin    DATABASE     �   CREATE DATABASE spring_webcodein_admin WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1256';
 &   DROP DATABASE spring_webcodein_admin;
                postgres    false                        2615    261798    administration_schema    SCHEMA     %   CREATE SCHEMA administration_schema;
 #   DROP SCHEMA administration_schema;
                postgres    false            �            1259    278282 
   admin_user    TABLE     �  CREATE TABLE administration_schema.admin_user (
    id bigint NOT NULL,
    created_by character varying(255),
    created_on timestamp(6) without time zone,
    modified_by character varying(255),
    updated_on timestamp(6) without time zone,
    dob date,
    email character varying(100) NOT NULL,
    email_verified boolean,
    enabled boolean,
    first_name character varying(100),
    gender character varying(255),
    keycloakuuid character varying(255),
    last_name character varying(100),
    mobile character varying(255),
    phone character varying(255),
    username character varying(255),
    uuid character varying(255)
);
 -   DROP TABLE administration_schema.admin_user;
       administration_schema         heap    postgres    false    6            �            1259    278281    admin_user_id_seq    SEQUENCE     �   CREATE SEQUENCE administration_schema.admin_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE administration_schema.admin_user_id_seq;
       administration_schema          postgres    false    217    6                       0    0    admin_user_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE administration_schema.admin_user_id_seq OWNED BY administration_schema.admin_user.id;
          administration_schema          postgres    false    216            �            1259    261777    room    TABLE     �   CREATE TABLE public.room (
    room_id bigint NOT NULL,
    bed_info character varying(255),
    room_name character varying(255),
    room_number character varying(255)
);
    DROP TABLE public.room;
       public         heap    postgres    false            j           2604    278285    admin_user id    DEFAULT     �   ALTER TABLE ONLY administration_schema.admin_user ALTER COLUMN id SET DEFAULT nextval('administration_schema.admin_user_id_seq'::regclass);
 K   ALTER TABLE administration_schema.admin_user ALTER COLUMN id DROP DEFAULT;
       administration_schema          postgres    false    216    217    217            �          0    278282 
   admin_user 
   TABLE DATA           �   COPY administration_schema.admin_user (id, created_by, created_on, modified_by, updated_on, dob, email, email_verified, enabled, first_name, gender, keycloakuuid, last_name, mobile, phone, username, uuid) FROM stdin;
    administration_schema          postgres    false    217   �       �          0    261777    room 
   TABLE DATA           I   COPY public.room (room_id, bed_info, room_name, room_number) FROM stdin;
    public          postgres    false    215   �                  0    0    admin_user_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('administration_schema.admin_user_id_seq', 7, true);
          administration_schema          postgres    false    216            n           2606    278289    admin_user admin_user_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY administration_schema.admin_user
    ADD CONSTRAINT admin_user_pkey PRIMARY KEY (id);
 S   ALTER TABLE ONLY administration_schema.admin_user DROP CONSTRAINT admin_user_pkey;
       administration_schema            postgres    false    217            l           2606    261783    room room_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (room_id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public            postgres    false    215            �   �   x�u�Kj�0D��)�R$۫�b�Jr��(����6A���!�B?jQECU�O8@�< . ˄�G��8��:�O��z�x�|��������}�I@�E�(͆8f39!��<��"*�ՠ�wM���o◎��#��0��V}k���./7W�Vj.�mm��n�"x)Zk���M|�N��L�00��&�lf)$��Ƴ���y\�      �      x������ � �     