/* { dg-do compile { target i?86-*-* } } */
/* { dg-options "-W -Wall" } */

/* Verify that GCC correctly detects non-matching regparm attributes.  */
int __attribute__((regparm(3))) f (void);  /* { dg-error "previous" } */

int __attribute__((regparm(2))) f (void) { /* { dg-error "conflicting" } */
  return 0;
}
